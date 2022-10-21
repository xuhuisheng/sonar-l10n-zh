#!/bin/sh

set -e

javac Main.java

java Main core.properties
java Main core_zh.properties
