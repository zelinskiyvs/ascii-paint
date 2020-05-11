#Demo ASCII painter #
This application is demo project for drawing lines and rectangles in console
Commands:

Command | Description
------- | ----------
C 10 10 | draw canvas 10 x 10
L 1 1 10 10 | draw line from (1, 1) to (10, 10)
R 1 1 10 10 | draw rectangle with coordinates (1, 1), (1, 10), (10, 1), (10, 10)

Example:
```text
enter command:C 10 10
Unknown command was received: [C, 10, 10]
------------
|          |
|          |
|          |
|          |
|          |
|          |
|          |
|          |
|          |
|          |
------------

enter command:L 1 1 10 10
------------
|x         |
| x        |
|  x       |
|   x      |
|    x     |
|     x    |
|      x   |
|       x  |
|        x |
|         x|
------------

enter command:R 1 1 10 10
------------
|xxxxxxxxxx|
|xx       x|
|x x      x|
|x  x     x|
|x   x    x|
|x    x   x|
|x     x  x|
|x      x x|
|x       xx|
|xxxxxxxxxx|
------------

```
