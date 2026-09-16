import java.util.Random;

class Cube {
 private char[][][] cube;
// Initializing a solved cube, 6 faces, 3 rows, 3 cols for each face
 public Cube() { 
 cube = new char[6][3][3];
 char[] colors = {'W', 'R', 'B', 'O', 'G', 'Y'}; // White, Red, Blue, Orange, Green, Yellow
 for (int i = 0; i < 6; i++) {
 for (int j = 0; j < 3; j++) {
 for (int k = 0; k < 3; k++) {
 cube[i][j][k] = colors[i];
 }
 }
 }
 }
//function to print the cube out when required
 public void printCube() {
 String[] faceNames = {"White", "Red", "Blue", "Orange", "Green", "Yellow"};
 for (int i = 0; i < 6; i++) {
 System.out.println(faceNames[i] + " face:");
 for (int j = 0; j < 3; j++) {
 for (int k = 0; k < 3; k++) {
 System.out.print(cube[i][j][k] + " ");
 }
 System.out.println();
 }
 System.out.println();
 }
 }
 public void rotateRedFaceClockwise() {
 // Rotate the red face itself
 char temp;
 temp = cube[1][0][0]; 
 cube[1][0][0] = cube[1][2][0];
 cube[1][2][0] = cube[1][2][2];
 cube[1][2][2] = cube[1][0][2];
 cube[1][0][2] = temp;
 
 temp = cube[1][0][1];
 cube[1][0][1] = cube[1][1][0];
 cube[1][1][0] = cube[1][2][1];
 cube[1][2][1] = cube[1][1][2];
 cube[1][1][2] = temp;
 
 // Rotate the adjacent edges
 char[] tempEdge = new char[3];
 
 // Store the right column of the White face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][i][2];
 }
 
 // Move the left column of the green face to the right column of the White face
 for (int i = 0; i < 3; i++) {
 cube[0][i][2] = cube[4][i][2];
 }
 
 // Move the left column of the Yellow face to the left column of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[4][i][2] = cube[5][2-i][0];
 }
 
 // Move the right column of the Green face to the left column of the Yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][i][0] = cube[2][i][0];
 }
 
 // Move the stored right column of the White face to the right column of the Green face
 for (int i = 0; i < 3; i++) {
 cube[2][i][0] = tempEdge[2-i];
 }
 }
 
 public void rotateRedFaceCounterClockwise() {
 // Rotate the red face itself
 char temp;
 temp = cube[1][0][0];
 cube[1][0][0] = cube[1][0][2];
 cube[1][0][2] = cube[1][2][2];
 cube[1][2][2] = cube[1][2][0];
 cube[1][2][0] = temp;
 
 temp = cube[1][0][1];
 cube[1][0][1] = cube[1][1][2];
 cube[1][1][2] = cube[1][2][1];
 cube[1][2][1] = cube[1][1][0];
 cube[1][1][0] = temp;
 
 // Rotate the adjacent edges
 char[] tempEdge = new char[3];
 
 // Store the right column of the White face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][i][2];
 }
 
 // Move the right column of the Green face to the right column of the White face
 for (int i = 0; i < 3; i++) {
 cube[0][i][2] = cube[2][2-i][0];
 }
 
 // Move the left column of the Yellow face to the right column of the Green face
 for (int i = 0; i < 3; i++) {
 cube[2][i][0] = cube[5][i][0];
 }
 
 // Move the left column of the Blue face to the left column of the Yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][i][0] = cube[4][2-i][2];
 }
 
 // Move the stored right column of the White face to the left column of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[4][ i][2] = tempEdge[i];
 }
 }

 public void rotateGreenFaceClockwise() {
 // Rotate the green face itself
 char temp;
 temp = cube[4][0][0];
 cube[4][0][0] = cube[4][2][0];
 cube[4][2][0] = cube[4][2][2];
 cube[4][2][2] = cube[4][0][2];
 cube[4][0][2] = temp;
 
 temp = cube[4][0][1];
 cube[4][0][1] = cube[4][1][0];
 cube[4][1][0] = cube[4][2][1];
 cube[4][2][1] = cube[4][1][2];
 cube[4][1][2] = temp;
 
 // Rotate the adjacent edges
 char[] tempEdge = new char[3];
 
 // Store the bottom row of the white face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][2][i];
 }
 
 // Move the right column of the orange face to the bottom row of the white face
 for (int i = 0; i < 3; i++) {
 cube[0][2][i] = cube[3][2 - i][2];
 }
 
 // Move the top row of the yellow face to the right column of the orange face
 for (int i = 0; i < 3; i++) {
 cube[3][i][2] = cube[5][2][2-i];
 }
 
 // Move the left column of the red face to the top row of the yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][2][i] = cube[1][i][0];
 }
 
 // Move the stored bottom row of the white face to the left column of the red face
 for (int i = 0; i < 3; i++) {
 cube[1][i][0] = tempEdge[i];
 }
 } 

 public void rotateGreenFaceCounterClockwise() {
 // Rotate the green face itself
 char temp;
 temp = cube[4][0][0];
 cube[4][0][0] = cube[4][0][2];
 cube[4][0][2] = cube[4][2][2];
 cube[4][2][2] = cube[4][2][0];
 cube[4][2][0] = temp;
 
 temp = cube[4][0][1];
 cube[4][0][1] = cube[4][1][2];
 cube[4][1][2] = cube[4][2][1];
 cube[4][2][1] = cube[4][1][0];
 cube[4][1][0] = temp;
 
 // Rotate the adjacent edges
 char[] tempEdge = new char[3];
 
 // Store the bottom row of the white face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][2][i];
 }
 
 // Move the left column of the red face to the bottom row of the white face
 for (int i = 0; i < 3; i++) {
 cube[0][2][i] = cube[1][i][0];
 }
 
 // Move the top row of the yellow face to the left column of the red face
 for (int i = 0; i < 3; i++) {
 cube[1][i][0] = cube[5][2][ i];
 }
 
 // Move the right column of the orange face to the top row of the yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][2][i] = cube[3][2-i][2];
 }
 
 // Move the stored bottom row of the white face to the right column of the orange face
 for (int i = 0; i < 3; i++) {
 cube[3][i][2] = tempEdge[2-i];
 }
 } 

 public void rotateBlueFaceClockwise() {
 // Rotate the blue face itself
 char temp;
 temp = cube[2][0][0];
 cube[2][0][0] = cube[2][2][0];
 cube[2][2][0] = cube[2][2][2];
 cube[2][2][2] = cube[2][0][2];
 cube[2][0][2] = temp;

 temp = cube[2][0][1];
 cube[2][0][1] = cube[2][1][0];
 cube[2][1][0] = cube[2][2][1];
 cube[2][2][1] = cube[2][1][2];
 cube[2][1][2] = temp;

 // Rotate the adjacent edges
 char[] tempEdge = new char[3];

 // Store the top row of the white face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][0][i];
 }

 // Move the right side red to top white
 for (int i = 0; i < 3; i++) {
 cube[0][0][i] = cube[1][i][2];
 }

 // Move the top row of the yellow face to right side red
 for (int i = 0; i < 3; i++) {
 cube[1][i][2] = cube[5][0][i];
 }

 // Move the left column orange face to the top row of the yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][0][i] = cube[3][2-i][0];
 }

 // Move the stored top row of the Blue face to the top row of the Red face
 for (int i = 0; i < 3; i++) {
 cube[3][2-i][0] = tempEdge[i];
 }
 }

 public void rotateBlueFaceCounterClockwise() {
 // Rotate the blue face itself
 char temp;
 temp = cube[2][0][0];
 cube[2][0][0] = cube[2][0][2];
 cube[2][0][2] = cube[2][2][2];
 cube[2][2][2] = cube[2][2][0];
 cube[2][2][0] = temp;

 temp = cube[2][0][1];
 cube[2][0][1] = cube[2][1][2];
 cube[2][1][2] = cube[2][2][1];
 cube[2][2][1] = cube[2][1][0];
 cube[2][1][0] = temp;

 // Rotate the adjacent edges
 char[] tempEdge = new char[3];

 // Store the top row of the white face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][0][i];
 }

 // Move the top row of the Orange face to the top row of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[0][0][i] = cube[3][2-i][0];
 }

 // Move the top row of the yellow face to the left column of the Orange face
 for (int i = 0; i < 3; i++) {
 cube[3][i][0] = cube[5][0][2-i];
 }

 // Move the right column of the Red face to the top row of the yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][0][i] = cube[1][i][2];
 }

 // Move the stored top row of the Blue face to the top row of the Red face
 for (int i = 0; i < 3; i++) {
 cube[1][i][2] = tempEdge[i];
 }
 }
 public void rotateOrangeFaceClockwise() {
 // Rotate the blue face itself
 char temp;
 temp = cube[3][0][0];
 cube[3][0][0] = cube[3][2][0];
 cube[3][2][0] = cube[3][2][2];
 cube[3][2][2] = cube[3][0][2];
 cube[3][0][2] = temp;

 temp = cube[3][0][1];
 cube[3][0][1] = cube[3][1][0];
 cube[3][1][0] = cube[3][2][1];
 cube[3][2][1] = cube[3][1][2];
 cube[3][1][2] = temp;

 // Rotate the adjacent edges
 char[] tempEdge = new char[3];

 // Store the left column of the white face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][i][0];
 }

 // Move the right column of blue to left column of white
 for (int i = 0; i < 3; i++) {
 cube[0][i][0] = cube[2][2-i][2];
 }

 // move right column yellow to right column blue
 for (int i = 0; i < 3; i++) {
 cube[2][i][2] = cube[5][i][2];
 }

 // Move the left column green to right column yellow
 for (int i = 0; i < 3; i++) {
 cube[5][i][2] = cube[4][2-i][0];
 }

 // Move the stored left columun of white to left column green
 for (int i = 0; i < 3; i++) {
 cube[4][i][0] = tempEdge[i];
 }
 }
 public void rotateOrangeFaceCounterClockwise() {
 // Rotate the blue face itself
 char temp;
 temp = cube[3][0][0];
 cube[3][0][0] = cube[3][0][2];
 cube[3][0][2] = cube[3][2][2];
 cube[3][2][2] = cube[3][2][0];
 cube[3][2][0] = temp;

 temp = cube[3][0][1];
 cube[3][0][1] = cube[3][1][2];
 cube[3][1][2] = cube[3][2][1];
 cube[3][2][1] = cube[3][1][0];
 cube[3][1][0] = temp;

 // Rotate the adjacent edges
 char[] tempEdge = new char[3];

 // Store the left column of the white face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[0][i][0];
 }

 // Move the Left column of the green face to the left column of the white face
 for (int i = 0; i < 3; i++) {
 cube[0][i][0] = cube[4][i][0];
 }

 // move right column yellow to left colum green
 for (int i = 0; i < 3; i++) {
 cube[4][i][0] = cube[5][2-i][2];
 }

 // Move the right column of the blue face to right column of yellow face
 for (int i = 0; i < 3; i++) {
 cube[5][i][2] = cube[2][i][2];
 }

 // Move the stored left columun of white to right column of blue
 for (int i = 0; i < 3; i++) {
 cube[2][2-i][2] = tempEdge[i];
 }
 }
//function to scramble the cube, such that we can now use algorithms to solve the cube. 
 public void scramble(int moves) {
   String[] possibleMoves = {
      "rotateWhiteFaceClockwise", "rotateWhiteFaceCounterClockwise",
      "rotateRedFaceClockwise", "rotateRedFaceCounterClockwise",
      "rotateGreenFaceClockwise", "rotateGreenFaceCounterClockwise",
      "rotateBlueFaceClockwise", "rotateBlueFaceCounterClockwise",
      "rotateOrangeFaceClockwise", "rotateOrangeFaceCounterClockwise",
      "rotateYellowFaceClockwise", "rotateYellowFaceCounterClockwise"
  };
  Random rand = new Random();

  for (int i = 0; i < moves; i++) {
      int moveIndex = rand.nextInt(possibleMoves.length);
      switch (possibleMoves[moveIndex]) {
          case "rotateWhiteFaceClockwise":
              rotateWhiteFaceClockwise();
              break;
          case "rotateWhiteFaceCounterClockwise":
              rotateWhiteFaceCounterClockwise();
              break;
          case "rotateRedFaceClockwise":
              rotateRedFaceClockwise();
              break;
          case "rotateRedFaceCounterClockwise":
              rotateRedFaceCounterClockwise();
              break;
          case "rotateGreenFaceClockwise":
              rotateGreenFaceClockwise();
              break;
          case "rotateGreenFaceCounterClockwise":
              rotateGreenFaceCounterClockwise();
              break;
          case "rotateBlueFaceClockwise":
              rotateBlueFaceClockwise();
              break;
          case "rotateBlueFaceCounterClockwise":
              rotateBlueFaceCounterClockwise();
              break;
          case "rotateOrangeFaceClockwise":
              rotateOrangeFaceClockwise();
              break;
          case "rotateOrangeFaceCounterClockwise":
              rotateOrangeFaceCounterClockwise();
              break;
          case "rotateYellowFaceClockwise":
              rotateYellowFaceClockwise();
              break;
          case "rotateYellowFaceCounterClockwise":
              rotateYellowFaceCounterClockwise();
              break;
          default:
              break;
      }
  }
 }

 public void rotateWhiteFaceClockwise() {
 // Rotate the white face itself
 char temp;
 temp = cube[0][0][0];
 cube[0][0][0] = cube[0][2][0];
 cube[0][2][0] = cube[0][2][2];
 cube[0][2][2] = cube[0][0][2];
 cube[0][0][2] = temp;

 temp = cube[0][0][1];
 cube[0][0][1] = cube[0][1][0];
 cube[0][1][0] = cube[0][2][1];
 cube[0][2][1] = cube[0][1][2];
 cube[0][1][2] = temp;

 // Rotate the adjacent edges
 char[] tempEdge = new char[3];

 // Store the top row of the Blue face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[2][0][i];
 }

 // Move the top row of the Orange face to the top row of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[2][0][i] = cube[3][0][i];
 }

 // Move the top row of the Green face to the top row of the Orange face
 for (int i = 0; i < 3; i++) {
 cube[3][0][i] = cube[4][0][i];
 }

 // Move the top row of the Red face to the top row of the Green face
 for (int i = 0; i < 3; i++) {
 cube[4][0][i] = cube[1][0][i];
 }

 // Move the stored top row of the Blue face to the top row of the Red face
 for (int i = 0; i < 3; i++) {
 cube[1][0][i] = tempEdge[i];
 }
 }

 public void rotateWhiteFaceCounterClockwise() {
 // Rotate the white face itself
 char temp;
 temp = cube[0][0][0];
 cube[0][0][0] = cube[0][0][2];
 cube[0][0][2] = cube[0][2][2];
 cube[0][2][2] = cube[0][2][0];
 cube[0][2][0] = temp;

 temp = cube[0][0][1];
 cube[0][0][1] = cube[0][1][2];
 cube[0][1][2] = cube[0][2][1];
 cube[0][2][1] = cube[0][1][0];
 cube[0][1][0] = temp;

 // Rotate the adjacent edges
 char[] tempEdge = new char[3];

 // Store the top row of the Red face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[1][0][i];
 }

 // Move the top row of the Green face to the top row of the Red face
 for (int i = 0; i < 3; i++) {
 cube[1][0][i] = cube[4][0][i];
 }

 // Move the top row of the Orange face to the top row of the Green face
 for (int i = 0; i < 3; i++) {
 cube[4][0][i] = cube[3][0][i];
 }

 // Move the top row of the Blue face to the top row of the Orange face
 for (int i = 0; i < 3; i++) {
 cube[3][0][i] = cube[2][0][i];
 }

 // Move the stored top row of the Red face to the top row of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[2][0][i] = tempEdge[i];
 }
 }

 public void rotateYellowFaceClockwise() {
 // Rotate the yellow face itself
 char temp;
 temp = cube[5][0][0];
 cube[5][0][0] = cube[5][2][0];
 cube[5][2][0] = cube[5][2][2];
 cube[5][2][2] = cube[5][0][2];
 cube[5][0][2] = temp;
 
 temp = cube[5][0][1];
 cube[5][0][1] = cube[5][1][0];
 cube[5][1][0] = cube[5][2][1];
 cube[5][2][1] = cube[5][1][2];
 cube[5][1][2] = temp;
 
 // Rotate the adjacent edges
 char[] tempEdge = new char[3];
 
 // Store the bottom row of the Blue face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[2][2][i];
 }
 
 // Move the bottom row of the Red face to the bottom row of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[2][2][i] = cube[1][2][i];
 }
 
 // Move the bottom row of the Green face to the bottom row of the Red face
 for (int i = 0; i < 3; i++) {
 cube[1][2][i] = cube[4][2][i];
 }
 
 // Move the bottom row of the Orange face to the bottom row of the Green face
 for (int i = 0; i < 3; i++) {
 cube[4][2][i] = cube[3][2][i];
 }
 
 // Move the stored bottom row of the Blue face to the bottom row of the Orange face
 for (int i = 0; i < 3; i++) {
 cube[3][2][i] = tempEdge[i];
 }
 }
 

 public void rotateYellowFaceCounterClockwise() {
 // Rotate the yellow face itself
 char temp;
 temp = cube[5][0][0];
 cube[5][0][0] = cube[5][0][2];
 cube[5][0][2] = cube[5][2][2];
 cube[5][2][2] = cube[5][2][0];
 cube[5][2][0] = temp;
 
 temp = cube[5][0][1];
 cube[5][0][1] = cube[5][1][2];
 cube[5][1][2] = cube[5][2][1];
 cube[5][2][1] = cube[5][1][0];
 cube[5][1][0] = temp;
 
 // Rotate the adjacent edges
 char[] tempEdge = new char[3];
 
 // Store the bottom row of the Blue face temporarily
 for (int i = 0; i < 3; i++) {
 tempEdge[i] = cube[2][2][i];
 }
 
 // Move the bottom row of the Orange face to the bottom row of the Blue face
 for (int i = 0; i < 3; i++) {
 cube[2][2][i] = cube[3][2][i];
 }
 
 // Move the bottom row of the Green face to the bottom row of the Orange face
 for (int i = 0; i < 3; i++) {
 cube[3][2][i] = cube[4][2][i];
 }
 
 // Move the bottom row of the Red face to the bottom row of the Green face
 for (int i = 0; i < 3; i++) {
 cube[4][2][i] = cube[1][2][i ];
 }
 
 // Move the stored bottom row of the Blue face to the bottom row of the Red face
 for (int i = 0; i < 3; i++) {
 cube[1][2][i] = tempEdge[i];
 }
 } 
//function that aligns the white cross with the correct side. It ensures that the white cross is correctly orientated, with each side matching to its middle peice. 
 public void AlignWhiteCross(){
   while(true){
      //This is set up such that as soon as the correct colours are seen, the while loop is exited. 
      boolean[] boolArray = {false, false, false, false};
      int count =0;
      if (cube[1][0][1]=='R'){
         boolArray[0]=true;
      }
      if (cube[2][0][1]=='B'){
         boolArray[1]=true;
      }
      if (cube[3][0][1]=='O'){
         boolArray[2]=true;
      }
      if (cube[4][0][1]=='G'){
         boolArray[3]=true;
      }
      for (int i=0;i<4;i++){
         if (boolArray[i]==true){
            count ++;
         }
      }
      //At least one side should be aligned, and if not, then all you need to do is rotate the cube. 
      if (count ==0 || count ==1){
         rotateWhiteFaceClockwise();
         

      }
      //rearange the sides of the cross
      else if (count ==2){
         if (boolArray[0]==true && boolArray[1]==true){
            rotateGreenFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            break;
         }
         if (boolArray[1]==true && boolArray[2]==true){
            rotateRedFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            break;
         }
         if (boolArray[2]==true && boolArray[3]==true){
            rotateBlueFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            break;
         }
         if (boolArray[3]==true && boolArray[0]==true){
            rotateOrangeFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            break;
         }
         if (boolArray[0]==true && boolArray[2]==true){
            rotateBlueFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            
         }
         if (boolArray[1]==true && boolArray[3]==true){
            rotateRedFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateWhiteFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateWhiteFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            
         }
      }
      if (count==4){
         break;
      }
   }
 }
 //function that allows us to easily check the colour of a square on the cube
 public char checkColour(int i,int j, int k){
   char temp = cube[i][j][k];
   return temp;
 }
 //a function that solves the corners on the white side of the rubik's cube. Also ensures the orientation and position are correct. 
 public void solveWhiteCorners(){
   while(true){
      boolean[] boolArray = {false, false, false, false};
      int count =0;
      //checking if the 4 corners are in the correct spot, if they are, then the loop is exited. 
      if (cube[0][0][0]=='W'&&cube[2][0][2]=='B'&&cube[3][0][0]=='O'){
         boolArray[0]=true;
      }
      if (cube[0][2][0]=='W'&&cube[3][0][2]=='O'&&cube[4][0][0]=='G'){
         boolArray[1]=true;
      }
      if (cube[0][2][2]=='W'&&cube[4][0][2]=='G'&&cube[1][0][0]=='R'){
         boolArray[2]=true;
      }
      if (cube[0][0][2]=='W'&&cube[1][0][2]=='R'&&cube[2][0][0]=='B'){
         boolArray[3]=true;
      }
      for (int i=0;i<4;i++){
         if (boolArray[i]==true){
            count++;
         }
      }
      if (count==4){
         break;
      }
      //now, we move around the corners if they are not already in the correct spot
      if (cube[5][0][0]=='W'){
         char temp1= checkColour(0, 0, 2);
         char temp2=checkColour(0, 0, 0);
         char temp3=checkColour(0, 2, 0);
         char temp4=checkColour(0, 2, 2);
         if (temp1!='W'){
            rotateRedFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            System.out.println(1);
            char temp = checkColour(4, 2, 0);
            if (temp=='B'){
               rotateYellowFaceClockwise();
               rotateBlueFaceCounterClockwise();
               rotateYellowFaceClockwise();
               rotateBlueFaceClockwise();
               System.out.println(2);
            }
            if (temp=='R'){
               rotateRedFaceCounterClockwise();
               rotateYellowFaceClockwise();
               rotateRedFaceClockwise();
               System.out.println(3);
            }
            if (temp=='O'){
               rotateYellowFaceClockwise();
               rotateYellowFaceClockwise();
               rotateOrangeFaceCounterClockwise();
               rotateYellowFaceClockwise();
               rotateOrangeFaceClockwise();
               System.out.println(4);
            }
            if (temp=='G'){
               rotateYellowFaceCounterClockwise();
               rotateGreenFaceCounterClockwise();
               rotateYellowFaceClockwise();
               rotateGreenFaceClockwise();
               System.out.println(5);
            }
         }
         else if (temp2!='W'){
            rotateYellowFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateOrangeFaceClockwise();
            System.out.println(6);
            char temp = checkColour(4, 2, 2);
            if (temp=='B'){
               rotateYellowFaceCounterClockwise();
               rotateBlueFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateBlueFaceCounterClockwise();
               System.out.println(7);
            }
            if (temp=='R'){
               rotateYellowFaceClockwise();
               rotateYellowFaceClockwise();
               rotateRedFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateRedFaceCounterClockwise();
               System.out.println(8);
            }
            if (temp=='O'){
               rotateOrangeFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceCounterClockwise();
               System.out.println(9);
            }
            if (temp=='G'){
               rotateYellowFaceClockwise();
               rotateGreenFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateGreenFaceCounterClockwise();
               System.out.println(10);
            }
            
         }
         else if (temp3!='W'){
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateGreenFaceClockwise();
            System.out.println(11);
            char temp = checkColour(1, 2, 2);
            if (temp=='B'){
               rotateYellowFaceCounterClockwise();
               rotateYellowFaceCounterClockwise();
               rotateBlueFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateBlueFaceCounterClockwise();
               System.out.println(12);
            }
            else if (temp=='R'){
               rotateYellowFaceClockwise();
               rotateRedFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateRedFaceCounterClockwise();
               System.out.println(13);
            }
            else if (temp=='O'){
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceCounterClockwise();
               System.out.println(14);
            }
            if (temp=='G'){
               rotateGreenFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateGreenFaceCounterClockwise();
               System.out.println(15);
            }
            
         }
         else if (temp4 !='W'){
            rotateYellowFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateRedFaceClockwise();
            System.out.println(16);
            char temp = checkColour(2, 2, 2);
            if (temp=='B'){
               rotateYellowFaceClockwise();
               rotateBlueFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateBlueFaceCounterClockwise();
               System.out.println(17);
            }
            if (temp=='R'){
               rotateRedFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateRedFaceCounterClockwise();
               System.out.println(18);
            }
            if (temp=='O'){
               rotateYellowFaceClockwise();
               rotateYellowFaceClockwise();
               rotateOrangeFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceCounterClockwise();
               System.out.println(19);
            }
            if (temp=='G'){
               rotateYellowFaceCounterClockwise();
               rotateGreenFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateGreenFaceCounterClockwise();
               System.out.println(20);
            }
         }
      }
      //if there is a white peice that is not in the position dealt with above, rotate the yellow side so that it is now in a position that can have the algorithm above work
      else if( cube[5][2][0]=='W'){
         rotateYellowFaceClockwise();
         System.out.println(21);
      }
      else if( cube[5][2][2]=='W'){
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         System.out.println(22);
      }
      else if( cube[5][0][2]=='W'){
         rotateYellowFaceCounterClockwise();
         System.out.println(23);
      }  
      else if (cube [1][2][0]=='W'){
         char temp=checkColour(4, 2, 2);
         System.out.println(24);
         if (temp =='G'){
            rotateYellowFaceClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            System.out.println(25);
         }
         if (temp == 'B'){
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            System.out.println(26);
         }
         if(temp=='R'){
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateRedFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceCounterClockwise();  
            System.out.println(27);
         }
         if (temp =='O'){
            rotateOrangeFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceCounterClockwise();
            System.out.println(28);
         }
      }
      else if (cube [1][2][2]=='W'){
         char temp = checkColour(2, 2, 0);
         System.out.println(29);
         if (temp =='G'){
            rotateYellowFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateGreenFaceClockwise();
            System.out.println(30);
         }
         if (temp == 'B'){
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateBlueFaceClockwise();
            System.out.println(31);
         }
         if  (temp=='R'){
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateRedFaceClockwise();  
            System.out.println(32);
         }
         if (temp =='O'){
            rotateOrangeFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateOrangeFaceClockwise();
            System.out.println(33);
         }
         
      }
      else if (cube [2][2][0]=='W'){
         rotateYellowFaceCounterClockwise();
         System.out.println(34);
      }
      else if (cube [2][2][2]=='W'){
         rotateYellowFaceCounterClockwise();
         System.out.println(35);
      }
      else if (cube [3][2][0]=='W'){
         rotateYellowFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         System.out.println(36);
      }
      else if (cube [3][2][2]=='W'){
         rotateYellowFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         System.out.println(37);
      }
      else if (cube [4][2][0]=='W'){
         rotateYellowFaceClockwise();
         System.out.println(38);
      }
      else if (cube [4][2][2]=='W'){
         rotateYellowFaceClockwise();
         System.out.println(39);
      }
      else if (cube [1][0][0]=='W'){
         rotateGreenFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         System.out.println(40);
      }
      else if (cube[1][0][2]=='W'){
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceClockwise();
         System.out.println(41);
      }
      else if (cube [2][0][0]=='W'){
         rotateRedFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         System.out.println(42);
      }
      else if (cube[2][0][2]=='W'){
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceClockwise();
         System.out.println(43);
      }
      else if (cube [3][0][0]=='W'){
         rotateBlueFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         System.out.println(44);
      }
      else if (cube[3][0][2]=='W'){
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceClockwise();
         System.out.println(45);
      }
      else if (cube [4][0][0]=='W'){
         rotateOrangeFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         System.out.println(46);
      }
      else if (cube[4][0][2]=='W'){
         rotateRedFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceClockwise();
         System.out.println(47);
      }
      else if (cube[0][0][0]=='W'&& cube[3][0][0]!='O'){
         rotateBlueFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         System.out.println(48);
      }
      else if (cube[0][2][0]=='W'&& cube[4][0][0]!='G'){
         rotateOrangeFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         System.out.println(49);
      }
      else if (cube[0][2][2]=='W'&& cube[1][0][0]!='R'){
         rotateGreenFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         System.out.println(50);
      }
      else if (cube[0][0][2]=='W' && cube[2][0][0]!='O'){
         rotateRedFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         System.out.println(51);
      }
   }

 }
//function to solve the cross on the white side of the cube, the first step to solve the cube. 
 public void solveCross(){
   while(true){
      boolean[] boolArray = {false, false, false, false};
      int count =0;
      //once the cross is created, exit the cube. 
      if (cube[0][1][0]=='W'){
         boolArray[0]=true;
      }
      if (cube[0][0][1]=='W'){
         boolArray[1]=true;
      }
      if (cube[0][2][1]=='W'){
         boolArray[2]=true;
      }
      if (cube[0][1][2]=='W'){
         boolArray[3]=true;
      }
      for (int i=0;i<4;i++){
         if (boolArray[i]==true){
            count++;
         }
      }
      if (count==4){
         break;
      }
      //checking the possible positions of white middle peices, and bringing them to the white side
      if (cube[5][0][1]=='W'){
         char temp1=checkColour(0, 0, 1);
         if (temp1!='W'){
            rotateBlueFaceClockwise();
            rotateBlueFaceClockwise();
            System.out.println(52);
         }
         else {
            rotateWhiteFaceClockwise();
            System.out.println(53);
         }
      }
      //rotate the yellow face in a way such that the above algorithm can be used in all cases
      else if( cube[5][1][0]=='W'){
         rotateYellowFaceClockwise();
         System.out.println(54);
      }
      else if( cube[5][2][1]=='W'){
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         System.out.println(55);
      }
      else if( cube[5][1][2]=='W'){
         rotateYellowFaceCounterClockwise();
         System.out.println(56);
      }  
      else if (cube[1][0][1]=='W'){
         rotateBlueFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateRedFaceClockwise();
         rotateRedFaceClockwise();
         rotateBlueFaceCounterClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         rotateGreenFaceClockwise();
         System.out.println(57);
      }
      else if (cube[1][2][1]=='W'){
         if (cube[0][1][2]!='W'){
               rotateYellowFaceCounterClockwise();
               rotateBlueFaceClockwise();
               rotateGreenFaceCounterClockwise();
               rotateRedFaceCounterClockwise();
               rotateBlueFaceCounterClockwise();
               rotateGreenFaceClockwise();
               System.out.println(58);
         }
         else {
            rotateWhiteFaceCounterClockwise();
            System.out.println(61);
         }
      }
      else if(cube[2][0][1]=='W'||cube[3][0][1]=='W'||cube[4][0][1]=='W'){
         rotateWhiteFaceClockwise();
         System.out.println(62);
      }
      else if(cube[2][2][1]=='W'||cube[3][2][1]=='W'||cube[4][2][1]=='W'){
         rotateYellowFaceClockwise();
         System.out.println(65);
      }
      else if(cube[1][1][0]=='W'){
         if (cube[0][2][1]!='W'){
            rotateGreenFaceCounterClockwise();
            System.out.println(68);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(69);
         }
      }
      else if(cube[2][1][0]=='W'){
         if (cube[0][1][2]!='W'){
            rotateRedFaceCounterClockwise();
            System.out.println(70);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(71);
         }
      }
      else if(cube[3][1][0]=='W'){
         if (cube[0][0][1]!='W'){
            rotateBlueFaceCounterClockwise();
            System.out.println(72);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(73);
         }
      }
      else if(cube[4][1][0]=='W'){
         if (cube[0][1][0]!='W'){
            rotateOrangeFaceCounterClockwise();
            System.out.println(74);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(75);
         }
      }
      else if(cube[1][1][2]=='W'){
         if (cube[0][0][1]!='W'){
            rotateBlueFaceClockwise();
            System.out.println(76);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(77);
         }
      }
      else if(cube[2][1][2]=='W'){
         if (cube[0][1][0]!='W'){
            rotateOrangeFaceClockwise();
            System.out.println(78);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(79);
         }
      }
      else if(cube[3][1][2]=='W'){
         if (cube[0][2][1]!='W'){
            rotateGreenFaceClockwise();
            System.out.println(80);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(81);
         }
      }
      else if(cube[4][1][2]=='W'){
         if (cube[0][1][2]!='W'){
            rotateRedFaceClockwise();
            System.out.println(82);
         }
         else{
            rotateWhiteFaceClockwise();
            System.out.println(83);
         }
      }
   }
}
//solving the middle layer of the cube
public void solveMiddle(){
   while(true){
      //keep running through the loop until the entire middle layer of the cube is correctly orientated
      boolean[] boolArray = {false, false, false, false, false, false, false, false};
      int count =0;
      if (cube[1][1][0]=='R'){
         boolArray[0]=true;
      }
      if (cube[1][1][2]=='R'){
         boolArray[1]=true;
      }
      if (cube[2][1][0]=='B'){
         boolArray[2]=true;
      }
      if (cube[2][1][2]=='B'){
         boolArray[3]=true;
      }
      if (cube[3][1][0]=='O'){
         boolArray[4]=true;
      }
      if (cube[3][1][2]=='O'){
         boolArray[5]=true;
      }
      if (cube[4][1][0]=='G'){
         boolArray[6]=true;
      }
      if (cube[4][1][2]=='G'){
         boolArray[7]=true;
      }
      for (int i=0;i<8;i++){
         if (boolArray[i]==true){
            count++;
         }
      }
      if (count==8){
         break;
      }
      //fill middle layer with all yellow tiles
      //clear red-blue intersection by inserting a yellow tile
      if(cube[1][1][2]!='Y' && cube[2][1][0]!='Y' && (cube[1][1][2]!='R' || cube [2][1][0] != 'B')){
         if (cube[5][0][1]=='Y' || cube [2][2][1] == 'Y'){
            rotateYellowFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateRedFaceClockwise();
            rotateGreenFaceClockwise();
            rotateBlueFaceCounterClockwise();
            System.out.println(84);
         }
         else{
            rotateYellowFaceClockwise();
            System.out.println(85);
         }
      }
      //clear blue-orange intersection by inserting a yellow tile
      else if(cube[2][1][2]!='Y' && cube[3][1][0]!='Y' && (cube[2][1][2]!='B' || cube [3][1][0] != 'O')){
         if (cube[5][1][2]=='Y' || cube [3][2][1] == 'Y'){
            rotateYellowFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateBlueFaceClockwise();
            rotateRedFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            System.out.println(86);
         }
         else{
            rotateYellowFaceClockwise();
            System.out.println(87);
         }
      }
      //clear orange-green intersection by inserting a yellow tile
      else if(cube[3][1][2]!='Y' && cube[4][1][0]!='Y' && (cube[3][1][2]!='O' || cube [4][1][0] != 'G')){
         if (cube[5][2][1]=='Y' || cube [4][2][1] == 'Y'){
            rotateYellowFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateOrangeFaceClockwise();
            rotateBlueFaceClockwise();
            rotateGreenFaceCounterClockwise();
            System.out.println(88);
         }
         else{
            rotateYellowFaceClockwise();
            System.out.println(89);
         }
      }
      //clear green-red intersection by inserting a yellow tile
      else if(cube[4][1][2]!='Y' && cube[1][1][0]!='Y' && (cube[4][1][2]!='G' || cube [1][1][0] != 'R')){
         if (cube[5][1][0]=='Y' || cube [1][2][1] == 'Y'){
            rotateYellowFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateGreenFaceClockwise();
            rotateOrangeFaceClockwise();
            rotateRedFaceCounterClockwise();
            System.out.println(90);
         }
         else{
            rotateYellowFaceClockwise();
            System.out.println(91);
         }
      }
      //matching the reds to their correct spot in the middle layer
      else if ((cube[1][2][1]=='R' || cube[5][1][0]=='R') && cube [1][2][1]!='Y' && cube[5][1][0]!='Y'){
         //now, use if statements to determine the correct algorithm to put the peice into the correct spot. 
         if (cube[1][2][1]=='R'){
            if (cube[5][1][0]=='G'){
               rotateYellowFaceClockwise();
               rotateOrangeFaceCounterClockwise();
               rotateGreenFaceClockwise();
               rotateRedFaceCounterClockwise();
               rotateOrangeFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateRedFaceClockwise();
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceCounterClockwise();
               rotateRedFaceClockwise();
               rotateGreenFaceClockwise();
               rotateOrangeFaceClockwise();
               rotateRedFaceCounterClockwise();
               System.out.println(92);
            }
            else{
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceClockwise();
               rotateBlueFaceCounterClockwise();
               rotateRedFaceClockwise();
               rotateOrangeFaceCounterClockwise();
               rotateYellowFaceClockwise();
               rotateRedFaceCounterClockwise();
               rotateYellowFaceCounterClockwise();
               rotateRedFaceCounterClockwise();
               rotateOrangeFaceClockwise();
               rotateBlueFaceClockwise();
               rotateRedFaceClockwise();
               rotateOrangeFaceCounterClockwise();
               System.out.println(93);
            }
         }
         else if(cube[1][2][1]=='G'){
            rotateYellowFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateRedFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            System.out.println(94);
         }
         else{
            rotateYellowFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateRedFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            System.out.println(95);
         }
      }

      //rotate reds if they are not in the correct spot for the above algorithm to be used. 
      else if ((cube[2][2][1]=='R' || cube[5][0][1]=='R') && cube [2][2][1]!='Y' && cube[5][0][1]!='Y'){
         rotateYellowFaceCounterClockwise();
         System.out.println(96);
      }
      else if ((cube[3][2][1]=='R' || cube[5][1][2]=='R') && cube [3][2][1]!='Y' && cube[5][1][2]!='Y'){
         rotateYellowFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         System.out.println(97);
      }
      
      else if ((cube[4][2][1]=='R' || cube[5][2][1]=='R') && cube [4][2][1]!='Y' && cube[5][2][1]!='Y'){
         rotateYellowFaceClockwise();
         System.out.println(98);
      }

      //Now repeate the whole red process for orange and then we are done. Including rotations
      else if ((cube[3][2][1]=='O' || cube[5][1][2]=='O') && cube [3][2][1]!='Y' && cube[5][1][2]!='Y'){
         if (cube[3][2][1]=='O'){
            if (cube[5][1][2]=='G'){
               rotateYellowFaceCounterClockwise();
               rotateRedFaceClockwise();
               rotateGreenFaceCounterClockwise();
               rotateRedFaceCounterClockwise();
               rotateOrangeFaceClockwise();
               rotateYellowFaceClockwise();
               rotateOrangeFaceCounterClockwise();
               rotateYellowFaceCounterClockwise();
               rotateOrangeFaceCounterClockwise();
               rotateRedFaceClockwise();
               rotateGreenFaceClockwise();
               rotateOrangeFaceClockwise();
               rotateRedFaceCounterClockwise();
               System.out.println(99);
            }
            else{
            rotateYellowFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateBlueFaceClockwise();
            rotateRedFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            System.out.println(100);
            }
         }
         else if(cube[3][2][1]=='G'){
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateOrangeFaceClockwise();
            rotateBlueFaceClockwise();
            rotateGreenFaceCounterClockwise();
            System.out.println(101);
         }
         else{
            rotateYellowFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateOrangeFaceClockwise();
            rotateBlueFaceClockwise();
            rotateGreenFaceCounterClockwise();
            System.out.println(102);
         }
      }
      //shuffle spots if not acurate for the above algorithm
      else if ((cube[2][2][1]=='O' || cube[5][0][1]=='O') && cube [2][2][1]!='Y' && cube[5][0][1]!='Y'){
         rotateYellowFaceClockwise();
         System.out.println(103);
      }
      else if ((cube[1][2][1]=='O' || cube[5][1][0]=='O') && cube [1][2][1]!='Y' && cube[5][1][0]!='Y'){
         rotateYellowFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         System.out.println(104);
      }
      
      else if ((cube[4][2][1]=='O' || cube[5][2][1]=='O') && cube [4][2][1]!='Y' && cube[5][2][1]!='Y'){
         rotateYellowFaceCounterClockwise();
         System.out.println(105);
      }
   }
}
//developing the yellow cross as the first step to solve the yellow side
public void getYellowCross(){
   while(true){
      if (cube[5][0][1]=='Y' &&cube[5][1][2]=='Y'&&cube[5][2][1]=='Y' &&cube[5][1][0]=='Y'){
         break;
      }
      else if (cube[5][0][1]=='Y'&&cube[5][2][1]=='Y'){
         rotateRedFaceClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         System.out.println(1);
         break;
      }
      else if (cube[5][1][0]=='Y'&&cube[5][1][2]=='Y'){
         rotateGreenFaceClockwise();
         rotateOrangeFaceClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         System.out.println(2);
         break;
      }
      else if (cube[5][0][1]=='Y'&&cube[5][1][0]=='Y'){
         rotateBlueFaceClockwise();
         rotateRedFaceClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         System.out.println(3);
      }
      else if (cube[5][1][0]=='Y'&&cube[5][2][1]=='Y'){
         rotateRedFaceClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         System.out.println(4);
      }
      else if (cube[5][1][2]=='Y'&&cube[5][2][1]=='Y'){
         rotateGreenFaceClockwise();
         rotateOrangeFaceClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         System.out.println(5);
      }
      else if (cube[5][0][1]=='Y'&&cube[5][1][2]=='Y'){
         rotateOrangeFaceClockwise();
         rotateBlueFaceClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         System.out.println(6);
      }
      else{
         rotateRedFaceClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
      }
   }

}
//aligning the yellow cross such that each middle peice iS aligned with the correct side
public void AlignYellowCross(){
   
   while(true){
      boolean[] boolArray = {false, false, false, false};
      int count =0;
      if (cube[1][2][1]=='R'){
         boolArray[0]=true;
      }
      if (cube[2][2][1]=='B'){
         boolArray[1]=true;
      }
      if (cube[3][2][1]=='O'){
         boolArray[2]=true;
      }
      if (cube[4][2][1]=='G'){
         boolArray[3]=true;
      }
      for (int i=0;i<4;i++){
         if (boolArray[i]==true){
            count ++;
         }
      }
      if (count ==0 || count ==1){
         rotateYellowFaceClockwise();
         

      }
      else if (count ==2){
         if (boolArray[0]==true && boolArray[1]==true){
            rotateOrangeFaceClockwise();
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            break;
         }
         if (boolArray[1]==true && boolArray[2]==true){
            rotateGreenFaceClockwise();
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            break;
         }
         if (boolArray[2]==true && boolArray[3]==true){
            rotateRedFaceClockwise();
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateRedFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateRedFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            break;
         }
         if (boolArray[3]==true && boolArray[0]==true){
            rotateBlueFaceClockwise();
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateBlueFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateBlueFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            break;
         }
         if (boolArray[0]==true && boolArray[2]==true){
            rotateGreenFaceClockwise();
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateGreenFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateGreenFaceCounterClockwise();
            
         }
         if (boolArray[1]==true && boolArray[3]==true){
            rotateOrangeFaceClockwise();
            rotateYellowFaceClockwise();
            rotateYellowFaceClockwise();
            rotateOrangeFaceCounterClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceClockwise();
            rotateYellowFaceCounterClockwise();
            rotateOrangeFaceCounterClockwise();
         
            
         }
      }
      if (count==4){
         break;
      }
   }
 }
 //the last step involves setting up the yellow corners so that they are in the right spot
 public void yellowCorners(){
   while(true){
      boolean[] boolArray = {false, false, false, false};
      int count =0;
      if (cube[2][2][0]=='R'||cube[1][2][2]=='R'||cube[5][0][0]=='R'){
         if(cube[2][2][0]=='B'||cube[1][2][2]=='B'||cube[5][0][0]=='B'){
            boolArray[0]=true;   
            System.out.println(5);
}}
      if (cube[1][2][0]=='R'||cube[4][2][2]=='R'||cube[5][2][0]=='R'){
         if(cube[1][2][0]=='G'||cube[4][2][2]=='G'||cube[5][2][0]=='G'){
            boolArray[1]=true;  
            System.out.println(6); 
            
      }}
      if (cube[4][2][0]=='G'||cube[3][2][2]=='G'||cube[5][2][2]=='G'){
         if(cube[4][2][0]=='O'||cube[3][2][2]=='O'||cube[5][2][2]=='O'){
            boolArray[2]=true;
            System.out.println(7);    
      }}
      if (cube[3][2][0]=='O'||cube[2][2][2]=='O'||cube[5][0][2]=='O'){
         if(cube[3][2][0]=='B'||cube[2][2][2]=='B'||cube[5][0][2]=='B'){
            boolArray[3]=true;
            System.out.println(8);
    
      }}
      for (int i=0;i<4;i++){
         if (boolArray[i]==true){
            count ++;
         }}
      if(count ==4){
         break;
      }
      if (boolArray[0]==true || count ==0){
         rotateYellowFaceClockwise();
         rotateRedFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceClockwise();
         System.out.println(1);
      }
      if (boolArray[1]==true){
         rotateYellowFaceClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceClockwise();
         System.out.println(2);
      }
      if (boolArray[2]==true){
         rotateYellowFaceClockwise();
         rotateOrangeFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceClockwise();
         System.out.println(3);
      }
      if (boolArray[3]==true){
         rotateYellowFaceClockwise();
         rotateBlueFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceClockwise();
         System.out.println(4);
      }
 }}
 public void solveCube(){
   while(true){
      boolean[] boolArray = {false, false, false, false};
      int count =0;
      if (cube[5][0][0]=='Y'){
         boolArray[0]=true;
      }
      if (cube[5][0][2]=='Y'){
         boolArray[1]=true;
      }
      if (cube[5][2][2]=='Y'){
         boolArray[2]=true;
      }
      if (cube[5][2][0]=='Y'){
         boolArray[3]=true;
      }
      for (int i=0;i<4;i++){
         if (boolArray[i]==true){
            count ++;
         }
      }
      if(count==4){
         break;
      }
      if(boolArray[0]==true &&boolArray[3]==false){
         rotateGreenFaceClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceClockwise();
      }
      else if(boolArray[1]==true &&boolArray[0]==false){
         rotateRedFaceClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceClockwise();
      }
      else if(boolArray[2]==true &&boolArray[1]==false){
         rotateBlueFaceClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateBlueFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateBlueFaceCounterClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateGreenFaceClockwise();
      }
      else if(boolArray[3]==true &&boolArray[2]==false){
         rotateOrangeFaceClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceClockwise();
      }
      else if (count ==0){
         rotateOrangeFaceClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceClockwise();
         rotateYellowFaceCounterClockwise();
         rotateOrangeFaceCounterClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceCounterClockwise();
         rotateYellowFaceClockwise();
         rotateRedFaceClockwise();
      }
   
   
   
   }

 }
 //now, we run the code to see the results
 public static void main(String[] args) {
 Cube myCube = new Cube();
 myCube.scramble(1000);
 myCube.printCube();
 myCube.solveCross();
 myCube.AlignWhiteCross();
 myCube.solveWhiteCorners();
 
 myCube.solveMiddle();

 myCube.getYellowCross();

 myCube.AlignYellowCross();
 
 
 myCube.yellowCorners();

 myCube.solveCube();
 myCube.printCube();
 }
 
 
}