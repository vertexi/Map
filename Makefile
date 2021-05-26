current_dir = $(shell pwd)
compiler    = /mnt/c/Program\ Files\ \(x86\)/processing-3.5.4-windows64/processing-3.5.4/processing-java.exe
sketch      = C:\\Users\\Apoptosis\\Documents\\Processing\\map

target:
	${compiler} --force --sketch=${sketch} --output=${sketch}\\out --run

tags:
	ctags -R --langmap=java:.pde --exclude=build-tmp

data:
	cp ./data_process/processed_data/*.csv ./data/userdata/
	cp ./data_process/processed_data/china_centroid.csv ./data/country_centroids.csv
	cp ./data_process/processed_data/hebei_countries.geo.json ./data/countries.geo.json
