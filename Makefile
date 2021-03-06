current_dir = $(shell pwd)
compiler    = /mnt/c/Program\ Files\ \(x86\)/processing-3.5.4-windows64/processing-3.5.4/processing-java.exe
sketch      = C:\\Users\\Apoptosis\\Documents\\Processing\\map

target:
	${compiler} --force --sketch=${sketch} --output=${sketch}\\out --run

tags:
	ctags -R --langmap=java:.pde --exclude=build-tmp

clean:
	rm -f ./data/userdata/*.csv
	rm -f ./data/*.csv
	rm -f ./data/countries.geo.json
	rm -f ./data_process/processed_data/*
