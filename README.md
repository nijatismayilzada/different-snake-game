# Different Snake Game

Different Snake Game is a small indie game. It is a puzzle game designed to show the capabilities of basic Android Graphics. During the development of this, I have not used any gamin libraries. All graphics are drawn by Android Graphics library on plain canvas. A couple of specific points worth mentioning:

* Game board size, cell size are dynamically calculated at the start of the game. This was required since every device is different, therefore you have to calculate properly for knowing where to draw game objects, such as snake, cells, etc.
* All game objects are vector graphics (except launcher icon), so they are screen size independent. 
* Game uses SQLite database to store and load all game details. This lets me continue the game from the same point as the user left, while also providing a separate checkpoint system.
* SQLite game board saving is asynchronous for not interrupting the game.
* Different game mechanics are unlocked during level progress. This help for more interactive user progress.
* Banner and Interstitial ads are present. Interstitial ads only appear on menu activity after multiple attempts. So, not bloating whole game with ads.
* Written in Java, looking at you, Kotlin for the next app!
* Game is overall written with clean code and I believe I should be able to easily extend it with new mechanics and levels.