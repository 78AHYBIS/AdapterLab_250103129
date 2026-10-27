# CSS 217 — Proxy & Bridge Pattern Lab

Six hands-on tasks covering two GoF structural patterns in plain Java (no external libraries).
Every task has its own `main()` whose output matches the worksheet's expected console log.

## Tasks

| # | Pattern | Scenario | Entry point |
|---|---|---|---|
| 1 | Proxy (protection) | The Bouncer: `ProxyImage` blocks non-`ADMIN` users before the slow image load | `proxy.image.Task1Main` |
| 2 | Proxy (logging) | The View Counter: `ProxyVideo` audits every `play()` and lazy-loads once | `proxy.video.Task2Main` |
| 3 | Proxy (protection) | School Wi-Fi Firewall: `SchoolProxyInternet` blocks `gaming.com` / `socialmedia.com` | `proxy.firewall.Task3Main` |
| 4 | Bridge | New device: `SmartLight` plugs into `AdvancedRemote` with zero remote changes | `bridge.remote.Task4Main` |
| 5 | Bridge | New controller: `PartyRemote` drives a `Radio` with zero device changes | `bridge.remote.Task5Main` |
| 6 | Bridge | RPG: `Hero` x `Weapon` without an M x N class explosion | `bridge.rpg.Task6Main` |

## Run

```bash
javac -d out $(find src -name '*.java')
java -cp out proxy.image.Task1Main      # swap in any entry point above
./run-all.sh                            # compiles and runs all six
```

## Design notes

**Proxy** = same interface as the real object, but it controls *access to* or *creation of* it.

- The proxy `implements` the same interface (`Image`, `Video`, `Internet`), so client code can't tell it
  from the real thing, and nothing in the client changes when a proxy is added.
- The real object is created **lazily** (`if (real == null) real = new Real...`), so the expensive
  work (disk read, 4K download) only happens when it is actually needed, and only once.
- Task 1 puts the permission check *before* the lazy load, so a denied user never triggers the slow read.
- Why not just put `if (role.equals("ADMIN"))` in the client? Every caller would have to remember the
  check, and one forgotten check is a security hole. In the proxy it lives in exactly one place.

**Bridge** = split one class hierarchy into two (abstraction + implementor) joined by composition.

- `BasicRemote` (abstraction) *has a* `Device` (implementor). That field is the bridge.
- Remotes and devices now vary independently: Task 4 added a device and Task 5 added a remote feature,
  and neither touched the other side.
- Task 6 makes the maths concrete: with inheritance, 2 heroes x 2 weapons = 4 classes
  (`KnightWithSword`, ...), and every new weapon needs one class *per hero type*. With a bridge it is
  2 + 2 = 4 classes, and a new weapon is **one** class.

## Proxy vs Bridge vs Decorator (exam trap)

| Pattern | Interface | Intent |
|---|---|---|
| Proxy | Same as the real object | Control access / creation |
| Decorator | Same as the wrapped object | Add behaviour |
| Bridge | Two separate interfaces | Let two hierarchies vary independently |
