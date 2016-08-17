package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Administrator on 2016-08-16.
 */
public class Player {
    public int x;
    public int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static void movePlayer(Player player, Terminal terminal ) throws InterruptedException {
        Key key;
        do{
            Thread.sleep(5);
            key =terminal.readInput();


        }while(key == null);

        switch (key.getCharacter()) {
            case 'U':
                if(player.y <= 0) {
                    //player.y = 19;
                }
                else
                    player.y = player.y - 1;
                break;
            case 'L':
                if(player.x <= 0) {
                    //player.x = 1;
                }
                else
                    player.x = player.x - 1;
                break;
            case 'R':
                if(player.x >= 20) {
                    //player.x = 19;
                }

                else
                    player.x = player.x + 1;
                break;
            case 'D':

                if(player.y >= 20) {
                    //player.y = 0;
                }
                else
                    player.y = player.y + 1;
                break;
        }
        System.out.println(key.getCharacter()+ " " + key.getKind());
        System.out.println(player.x);
        System.out.println(player.y);

    }

}
