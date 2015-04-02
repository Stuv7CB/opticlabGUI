all:
	mkdir bin
	cd src
	javac -d ../bin Main.java
jar:
	cd bin
	jar cfm OpticLabGUI.jar ../MANIFEST.MD *
clean:
	rm -r -f ./bin