INCLUDES = -I/usr/local/Cellar/tesseract/3.00/include/tesseract `pkg-config --cflags opencv`
INCLUDES = `pkg-config --cflags opencv tesseract`
LIBS = -L/usr/local/Cellar/tesseract/3.00/lib -ltesseract_api `pkg-config --libs opencv`
LIBS = `pkg-config --libs opencv tesseract`
DYLIB = -arch x86_64 -dynamiclib -o libmicrocr.dylib
DYLIB = -o libmicrocr.so
INSTALL_PATH = -install_name /usr/local/lib/microcr/libmicrocr.dylib
INSTALL_PATH =
CC = g++

all: libmicrocr microcr clean_obj

libmicrocr: tesseract_api.o
	$(CC) $(DYLIB) tesseract_api.o image.o utils.o tesseract_proxy.o $(INSTALL_PATH) $(LIBS)

microcr: main.o camera.o
	$(CC) tesseract_api.o main.o camera.o image.o utils.o tesseract_proxy.o -o microcr $(LIBS)

main.o:  tesseract_api.o
	$(CC) $(INCLUDES) -c src/main.cpp

tesseract_api.o: utils.o image.o tesseract_proxy.o
	$(CC) $(INCLUDES) -c src/tesseract_api.cpp

camera.o:
	$(CC) $(INCLUDES) -c src/camera.cpp

image.o:
	$(CC) $(INCLUDES) -c src/image.cpp

utils.o:
	$(CC) $(INCLUDES) -c src/utils.cpp

tesseract_proxy.o:
	$(CC) $(INCLUDES) -c src/tesseract_proxy.cpp

clean_obj:
	rm -rf *.o

clean: clean_obj
	rm -rf microcr *.dylib *.so
