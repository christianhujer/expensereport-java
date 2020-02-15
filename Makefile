.PHONY: all
all:
	./mvnw package

-include .User.mk
-include ~/.User.mk
