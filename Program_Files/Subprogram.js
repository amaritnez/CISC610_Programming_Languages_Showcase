// Outer function
function outer() {
    var outerVar = 1;
    // Print out outer variable
    console.log("Outer function: outerVar = " + outerVar);
    // Middle function
    function middle() {
      var middleVar = 2;
      // Print out outer and middle variable
      console.log("Middle function: outerVar = " + outerVar + ", middleVar = " + middleVar);
      // Inner function
      function inner() {
        var innerVar = 3;
        // Print out all 3 variables
        console.log("Inner function: outerVar = " + outerVar + ", middleVar = " + middleVar + ", innerVar = " + innerVar);
      }
      // Call inner function last
      inner();
    }
    // Call middle function second   
    middle();
  }
  
  // Call outermost function first
  outer();
  