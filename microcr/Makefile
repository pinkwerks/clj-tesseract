ARCH = $(shell uname -m)
ifeq ($(ARCH),x86_64)
INCLUDES = `pkg-config --cflags opencv tesseract` -fPIC
DYLIB = -shared -o libmicrocr.so
LIBS = `pkg-config --libs opencv tesseract`
INSTALL_PATH =
else
INCLUDES = -I/usr/local/Cellar/tesseract/3.00/include/tesseract `pkg-config --cflags opencv`
DYLIB = -arch x86_64 -dynamiclib -o libmicrocr.dylib
LIBS = -L/usr/local/Cellar/tesseract/3.00/lib -ltesseract_api `pkg-config --libs opencv`
INSTALL_PATH = -install_name /usr/local/lib/microcr/libmicrocr.dylib
endif

all: libmicrocr microcr clean_obj

libmicrocr: tesseract_api.o
	$(CXX) $(INCLUDES) $(DYLIB) tesseract_api.o image.o utils.o tesseract_proxy.o $(INSTALL_PATH) $(LIBS)

microcr: main.o camera.o
	$(CXX) $(INCLUDES) tesseract_api.o main.o camera.o image.o utils.o tesseract_proxy.o -o microcr $(LIBS)

main.o:  tesseract_api.o
	$(CXX) $(INCLUDES) -c src/main.cpp

tesseract_api.o: utils.o image.o tesseract_proxy.o
	$(CXX) $(INCLUDES) -c src/tesseract_api.cpp

camera.o:
	$(CXX) $(INCLUDES) -c src/camera.cpp

image.o:
	$(CXX) $(INCLUDES) -c src/image.cpp

utils.o:
	$(CXX) $(INCLUDES) -c src/utils.cpp

tesseract_proxy.o:
	$(CXX) $(INCLUDES) -c src/tesseract_proxy.cpp

clean_obj:
	rm -rf *.o

clean: clean_obj
	rm -rf microcr *.dylib *.so
