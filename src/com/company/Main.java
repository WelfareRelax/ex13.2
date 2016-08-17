package com.company;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;

import static com.company.Player.movePlayer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        Player player = new Player(10,10);
        Enemy enemy = new Enemy(5,5);
            while(gameLogic(player, enemy)){
                //Wait for a key to be pressed

                movePlayer(player, terminal);
                updateScreen(player, enemy, terminal);
            }
        System.out.println("Game over");
        System.out.println("MYBRANCH");
    }

    private static boolean gameLogic(Player player, Enemy enemy) {
        // Jävligt bra skrivet
        int xdiff = player.x - enemy.x;
        int ydiff = player.y - enemy.y;
        if(xdiff == 0 && ydiff == 0) {
            return false;
        }

        if (Math.abs(xdiff) > Math.abs(ydiff)) {
            if (xdiff > 0)
                enemy.x = enemy.x + 1;
            else
                enemy.x = enemy.x - 1;
        } else {
            if (ydiff > 0)
                enemy.y = enemy.y + 1;
            else
                enemy.y = enemy.y - 1;
        }
        return true;

    }



    private static void updateScreen(Player player, Enemy enemy, Terminal terminal) {
        terminal.clearScreen();
        terminal.moveCursor(player.x,player.y);
        terminal.putCharacter('O');
        terminal.moveCursor(enemy.x,enemy.y);
        terminal.putCharacter('X');
        terminal.moveCursor(0,0);
    }




}


