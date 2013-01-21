package mm19.game.board;

import mm19.game.ships.Ship;

import java.util.ArrayList;

/**
 * 
 * @author mm19
 * 
 * The entity which keeps track of positions of ships.
 *
 */
public class Board {

    private Tile[][] tiles;
    private int width;



    private int height;

    private ArrayList<Ship> ships = new ArrayList<Ship>();

    /**
     * Constructor.  Takes a width and a height and initializes the double Tile array.
     * @param boardWidth
     * @param boardHeight
     */
    public Board(int boardWidth, int boardHeight){
        width = boardWidth;
        height = boardHeight;
        tiles = new Tile[width][height];
        for(int x = 0; x < width; x++) {
            for( int y = 0; y < height; y++){
                tiles[x][y] = new Tile();
            }
        }
    }

    /**
     * Returns the width of the board
     * @return int Board width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the board
     * @return int Board height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns a reference to a ship if it occupies coordinate (x,y) on the board.
     * @param x
     * @param y
     * @return A Ship if one exists at the position, null otherwise
     */
    public Ship getShip(int x, int y){
        if(inBounds(x,y) && isOccupied(x,y)){
            return tiles[x][y].getShip();
        } else {
            return null;
        }
    }



    /**
     * Given an (x,y) coordinate, determines if there is a corresponding board location.
     * @param x
     * @param y
     * @return returns true if cell is within bounds of double array, false if not.
     */
    private boolean inBounds(int x, int y){
        return (x >= 0) && (x < width) && (y >= 0) && (y < height);
    }

    /**
     * Given an (x,y) coordinate, reports if the board location is occupied
     * @param x
     * @param y
     * @return true is an object occupies Tile, false otherwise
     */
    private boolean isOccupied(int x, int y) {
        return tiles[x][y].isOccupied();
    }

    /**
     *
     * @author mm19
     *
     * The entities which make up the board
     *
     */
    public static class Tile {

        private boolean occupied = false;

        /**
         * Reference to the ship occupying this Tile.
         */
        private Ship currentShip = null;



        /**
         * Default Tile constructor
         */
        public Tile(){

        }

        /**
         * @return true if Tile is occupied, false if not.
         */
        public boolean isOccupied(){
            return occupied;
        }

        /**
         * Sets a reference to the ship currently occupying this Tile
         * @param ship
         */
        public void setShip(Ship ship){
            currentShip = ship;
            occupied = true;
        }

        /**
         * @return Returns a reference to the current ship.
         */
        public Ship getShip(){
            return currentShip;
        }

        /**
         * Removes a reference to the ship currently occupying this Tile
         */
        public void removeShip(){
            currentShip = null;
            occupied = false;
        }
    }
}