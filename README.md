# Dominos
Simulates Cardinal's Mexico Train Domino Game. For rules on this version of dominos see [here](https://www.mastersofgames.com/rules/mexican-train-dominoes-rules.htm)

## Usage
Sample initiation code to simulate a game is shown below:
```java
ArrayList<Bot> players = new ArrayList<Bot>();
Bot player1 = new Bot("Bob");
Bot player2 = new Bot("Jane");
players.add(player1);
players.add(player2);
Game g = new Game(players);
g.play();
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)

