# -*- coding: utf-8 -*-
"""
Created on Fri May 14 20:53:44 2021

@author: Apoptosis
"""

# %%
import matplotlib
import matplotlib.pyplot as plt
# import the geo data process library
import geopandas
import pandas as pd
import numpy as np

# for the file listing issue
import os
from os import listdir
from os.path import isfile, join, exists

# %%
# import Hebei province data
geo_df = geopandas.read_file("./china-geojson/geometryProvince/13.json")
# change the id to the name with utf-8 encoding
geo_df.loc[:,'id'] = geo_df.loc[:,'name']
if exists("Hebei.geojson"):
    os.remove("Hebei.geojson")
geo_df.to_file("Hebei.geojson", driver="GeoJSON", encoding="utf-8")

# %%
# try to plot the map and the centroids.
fig, ax = plt.subplots()
geo_df.plot(ax=ax)
geo_df['geometry'].centroid.plot(marker='*', color='red', ax=ax)
fig.show()

# %%
geo_centroids = pd.DataFrame(geo_df['geometry'].centroid.copy())
geo_centroids['name'] = geo_df['name'].copy()
geo_centroids.set_index('name', inplace=True)
geo_centroids.columns = ['centroids']
geo_centroids = geo_centroids['centroids'].apply(lambda x : [x.x, x.y])
geo_centroids = pd.DataFrame.from_dict(dict(zip(geo_centroids.index, geo_centroids.values))).T
geo_centroids.index.name = 'city'
geo_centroids.rename(columns={0:'longitude',1:'latitude'}, inplace=True)
geo_centroids['id'] = geo_centroids.index
geo_centroids = geo_centroids[['id','longitude','latitude']]




# %%
# listing files under the air_data directory
data_path = "./air_data/城市_20200101-20201231/"
# get the file names
files = [f for f in listdir(data_path) if isfile(join(data_path, f))]
# append the relavtive directory path
files = [data_path + f for f in files]

# concatenate all data sheet
data_df = pd.concat([pd.read_csv(f) for f in files], ignore_index=True)

# %%
# select the Hebei province data
Hebei_df = data_df[['date','hour','type']+list(geo_df['name'])].copy()
# turn the type into string
Hebei_df.loc[:,'type'] = Hebei_df.loc[:,'type'].astype('string').copy()
# remove the data type which don'
Hebei_df = Hebei_df[~Hebei_df.loc[:,'type'].str.contains('h')].copy()

# %%
# multindex classify the data
"""
example:
                       承德        张家口  ...          衡水          廊坊
type date                             ...                        
AQI  20200101   77.000000  50.291667  ...   78.458333   65.416667
     20200102  101.708333  45.541667  ...  132.375000   89.375000
     20200103   87.041667  43.458333  ...  176.291667  115.625000
     20200104   72.625000  37.541667  ...  265.541667  115.166667
     20200105   86.708333  67.750000  ...  233.333333   85.958333
                  ...        ...  ...         ...         ...
SO2  20201227   28.958333  23.750000  ...   27.260870   16.833333
     20201228   19.375000  12.083333  ...   17.666667   17.833333
     20201229    7.863636  13.272727  ...   15.000000    8.590909
     20201230    7.791667  13.333333  ...   13.375000    7.708333
     20201231   18.041667  17.916667  ...   22.083333   10.958333

[2562 rows x 11 columns]
"""
# get the type date average
Hebei_df = Hebei_df.groupby(['type','date']).mean().copy()
# drop the trivial hour column
Hebei_df.drop('hour',axis=1, inplace=True)

# %%
# get the air indicator's names
air_indicator_names = Hebei_df.index.get_level_values(0).unique()

# %%
for indicator_name in air_indicator_names:
    temp_indicator = Hebei_df.loc[indicator_name].T.stack()
    temp_indicator.name = indicator_name
    temp_indicator.to_csv("processed_data/"+indicator_name+".csv")
