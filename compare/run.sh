#!/bin/sh

set -e

javac Main.java

java Main core.properties
java Main core_ja.properties

clear

diff dest/core.properties dest/core_ja.properties
