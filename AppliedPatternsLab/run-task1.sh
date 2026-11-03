#!/usr/bin/env bash
# Compile everything and run the Task 1 verification runner.
set -e
cd "$(dirname "$0")"
rm -rf out
javac -d out $(find src -name '*.java')
java -cp out task1.Task1Runner
