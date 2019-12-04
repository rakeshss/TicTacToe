# TicTacToe: TDD implementation

<b>Story 1:</b> A piece can be placed on any empty space of a 3×3 board.

The above line can be converted into three test cases:<br>

Test case 1:  When a piece is placed anywhere outside the X axis, then RuntimeException is thrown.<br>
Test case 2:  When a piece is placed anywhere outside the Y axis, then RuntimeException is thrown.<br>
Test case 3:  When a piece is placed on an occupied space, then RuntimeException is thrown<br>

