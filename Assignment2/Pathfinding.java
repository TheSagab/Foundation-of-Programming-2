/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.*;

/**
 * Class yang digunakan untuk mencari shortest path dari suatu koordinat
 * Metode shortest path menggunakan breadth-first search (BFS)
 * Referensi BFS http://stackoverflow.com/questions/16366448/maze-solving-with-breadth-first-search
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Pathfinding {

    private static Map map = new Map();
    private static Character[][] modifiedMap = map.getMap();
    private static boolean[][] visited = new boolean[Map.HEIGHT][Map.WIDTH];

    /**
     * Inner class untuk merepresentasikan koordinat titik
     * Memiliki parent sebagai penunjuk titik sebelumnya
     */
    private static class Point {
        int x;
        int y;
        Point parent;

        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }

        public Point getParent() {
            return this.parent;
        }

        public String toString() {
            // biar bener dituker x dan y nya
            return "x = " + y + ", y = " + x;
        }
    }

    /**
     * Mencari koordinat X dari string
     * @param coordinate string suatu koordinat
     * @return koordinat X, -1 jika panjang string != 4
     */
    private static int getCoordinateX(String coordinate){
        if (coordinate.length() != 4) return -1;
        String x = coordinate.substring(0, 2);
        int coor = (x.charAt(0) - 'A') * 10 + Character.getNumericValue(x.charAt(1));
        return coor;
    }
    /**
     * Mencari koordinat Y dari string
     * @param coordinate string suatu koordinat
     * @return koordinat Y, -1 jika panjang string != 4
     */
    private static int getCoordinateY(String coordinate){
        if (coordinate.length() != 4) return -1;
        String y = coordinate.substring(2, 4);
        int coor = (y.charAt(0) - 'Q')  * 10 + Character.getNumericValue(y.charAt(1));
        return coor;
    }

    /**
     * Metode BFS untuk mencari jarak terpendek dari koordinat yang diberikan
     * @param x x awal
     * @param y y awal
     * @param xEnd x akhir
     * @param yEnd y akhir
     * @return point tempat tujuan, null jika tidak ditemukan jalan
     */
    private static Point getPathBFS(int x, int y, int xEnd, int yEnd) {
        // queue untuk menyimpan point yang disimpan
        // setiap loop while diambil 1 point untuk mengecek jalan
        // fungsi queue adalah untuk melakukan pencarian secara meluas (breadth-first)
        Queue<Point> q = new LinkedList<>();
        // reset ulang boolean
        for (int i=0;i<Map.HEIGHT;++i) for (int j=0;j<Map.WIDTH;++j) visited[i][j]=false;
        q.add(new Point(x,y, null));

        modifiedMap[xEnd][yEnd] = 'F';
        visited[x][y] = true;
        modifiedMap[x][y] = 'S';
        while(!q.isEmpty()) {
            Point p = q.remove();
            //System.out.println(q.size() + " " + p.x + " " + p.y);
            //Jika sampai finish
            if (modifiedMap[p.x][p.y] == 'F') {
                //System.out.println("Exit is reached!");
                return p;
            }
            // cek jalan
            if(isFree(p.x+1,p.y)) {
                //System.out.println("haha");
                Point nextP = new Point(p.x+1,p.y, p);
                visited[nextP.x][nextP.y] = true;
                q.add(nextP);
            }

            if(isFree(p.x-1,p.y)) {
                //System.out.println("haha");
                Point nextP = new Point(p.x-1,p.y, p);
                visited[nextP.x][nextP.y] = true;
                q.add(nextP);
            }

            if(isFree(p.x,p.y+1)) {
                //System.out.println("haha");
                Point nextP = new Point(p.x,p.y+1, p);
                visited[nextP.x][nextP.y] = true;
                q.add(nextP);
            }

            if(isFree(p.x,p.y-1)) {
                //System.out.println("haha");
                Point nextP = new Point(p.x,p.y-1, p);
                visited[nextP.x][nextP.y] = true;
                q.add(nextP);
            }

        }
        // jika tidak ada jalan ke finish
        return null;
    }

    /**
     * Cek jalan koordinat
     * @param x x
     * @param y y
     * @return true jika merupakan jalan
     */
    private static boolean isFree(int x, int y) {
        if((x >= 0 && x < Map.HEIGHT) && (y >= 0 && y < Map.WIDTH)
                && (modifiedMap[x][y] == ' ' || modifiedMap[x][y] == 'F') && (!visited[x][y])) {
            return true;
        }
        return false;
    }

    /**
     * Print map yang berisi jalan yang ditandai dengan tiitk
     */
    private static void printModifiedMap(){
        map.print();
    }

    /**
     * Mereset ulang map
     */
    private static void resetMap(){
        map = new Map();
        modifiedMap = map.getMap();
    }

    /**
     * Menghitung jarak terpendek dari koordinat yang diberikan
     * @param from string asal
     * @param to string tujuan
     * @return jarak (dalam satuan 100m), -1 jika tidak valid
     */
    public static int calculateDistance(String from, String to){
        int xStart = getCoordinateX(from);
        int xEnd = getCoordinateX(to);
        int yStart = getCoordinateY(from);
        int yEnd = getCoordinateY(to);
        // jika bukan koordinat yang valid (ex: G8U9)
        if(!(xStart > 0 && xStart < Map.HEIGHT) || !(yStart > 0 && yStart < Map.WIDTH)){
            System.out.println(from + " bukan koordinat yang valid!");
            return -1;
        }
        if(!(xEnd > 0 && xEnd < Map.HEIGHT) || !(yEnd > 0 && yEnd < Map.WIDTH)){
            System.out.println(to + " bukan koordinat yang valid!");
            return -1;
        }
        // jika menemui tembok
        if (modifiedMap[xStart][yStart] == '#') {
            System.out.println("Input tidak valid: " + from + " bukan jalan");
            return -1;
        }
        if(modifiedMap[xEnd][yEnd] == '#'){
            System.out.println("Input tidak valid: " + to + " bukan jalan");
            return -1;
        }
        //jika asal = tujuan (special case)
        if(from.equals(to)){
            modifiedMap[xEnd][yEnd] = 'F';
            printModifiedMap();
            resetMap();
            return 0;
        }
        // working case
        int dist = 0;
        Point p = getPathBFS(xStart, yStart, xEnd, yEnd);
        if (p == null) return -1;
        // lakukan traceback dari finish ke tujuan
        while(p.getParent() != null) {
            //System.out.println(p);
            modifiedMap[p.x][p.y] = '.';
            dist++;
            p = p.getParent();
        }
        modifiedMap[xEnd][yEnd] = 'F';
        printModifiedMap();
        resetMap();
        return dist;
    }

}
