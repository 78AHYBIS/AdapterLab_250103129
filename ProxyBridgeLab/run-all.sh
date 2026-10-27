#!/usr/bin/env bash
# Compile everything and run all six task entry points.
set -e
cd "$(dirname "$0")"
rm -rf out
javac -d out $(find src -name '*.java')

i=1
for cls in proxy.image.Task1Main proxy.video.Task2Main proxy.firewall.Task3Main \
           bridge.remote.Task4Main bridge.remote.Task5Main bridge.rpg.Task6Main; do
  echo "===== Task $i ($cls) ====="
  java -cp out "$cls"
  echo
  i=$((i + 1))
done
