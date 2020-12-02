#Chapter 4. Maps and Tuples

_1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with the same keys and the prices at a 10 percent discount._
```scala
val gizmos = Map("Smart Watches" -> 1200, "Shower Speaker" -> 650, "Portable Projector" -> 460)
for((gizmo, price) <- gizmos) yield (gizmo -> price * 0.9)```
