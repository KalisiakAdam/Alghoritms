/**
 * Created by kalisiaczki on 30.10.2017.
 */
public class Countries {

    public void searching(int[][] matrix, boolean[][] isVisited, int i, int j, int content){

        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || isVisited[i][j] || matrix[i][j] != content) return;

        isVisited[i][j] = true;
        searching(matrix, isVisited, i-1,j,content);
        searching(matrix, isVisited, i+1,j,content);
        searching(matrix, isVisited, i,j-1,content);
        searching(matrix, isVisited, i,j+1,content);
    }
    public int pointer(int[][] matrix){
        int numberOfCountries = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(!visited[i][j]){
                    numberOfCountries++;
                    searching(matrix, visited, i, j, matrix[i][j]);
                }
            }
        }
        return numberOfCountries;
    }

    public static void main(String[] args){
        Countries obj = new Countries();
        int [][] A = {
                {5,4,3,2,3,1,4,5},
                {5,4,3,2,3,1,4,5},
                {4,4,4,2,4,4,1,4,},
                {4,3,2,2,3,4,1,3},
                {4,4,4,2,4,4,1,3},
                {4,4,4,2,4,4,1,2},
                {4,4,4,2,4,4,1,7},

        };

        System.out.println(obj.pointer(A));
    }



}
