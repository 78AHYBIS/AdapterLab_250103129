#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"
rm -rf out
javac -d out $(find src -name '*.java')

for n in 1 2 3; do
  echo "===== Task $n ====="
  java -cp out task$n.Task${n}Runner
  echo
done
