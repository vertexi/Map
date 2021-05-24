# %%
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import os
import json

# %%
# china geo json parse data['features'][-1]['properties']['id']
with open("countries.geo.json") as ff:
    data_world = json.load(ff)

with open("china_countries.geo.json") as ff:
    data_china = json.load(ff)

# %%
for city in data_china['features']:
    ['properties']['id']
