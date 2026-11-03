# CSS 217 - Practical Design Patterns: Applied Engineering Lab

Plain Java (SE 8+), no external libraries. One package per task.

| Task | Patterns | Package | Entry point | Status |
|---|---|---|---|---|
| 1 | Strategy + Decorator (secure report exporter) | `task1` | `task1.Task1Runner` | done |
| 2 | Adapter + Proxy (legacy stock feed with TTL cache) | `task2` | `task2.Task2Runner` | done |
| 3 | Bridge + Strategy (alert engine with dispatch policy) | `task3` | `task3.Task3Runner` | done |
| 4 | Adapter + Decorator | `task4` | | not started |
| 5 | Bridge + Proxy | `task5` | | not started |

## Run

```bash
javac -d out $(find src -name '*.java')
java -cp out task2.Task2Runner      # swap in any entry point above
./run-all.sh                        # compiles and runs tasks 1-3
```
