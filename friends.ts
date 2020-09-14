// an auxiliary method that randomized array for testing
const shuffle = (array:any[]) =>
  array.sort(() => Math.random() - 0.5);

const organizeGiftExchange = (friends:string[]) => {
  const len = friends.length;
  if (len < 3) {
    console.log(`Sorry, not enough friends to exchange gifts with!`);
  } else {
    friends.forEach((friend, idx) => {
      console.log(`${friend} gives a gift to ${friends[(idx + 1) % len]}`);
    })
  }
  return '';
}

const tester = () => {
    // same input, but different results each run
    let friends = ['One', 'Two', 'Three', 'Four', 'Five'];
    console.log(organizeGiftExchange(shuffle(friends)));
    console.log(organizeGiftExchange(shuffle(friends)));
    console.log(organizeGiftExchange(shuffle(friends)));

    // least number of friends that can be processed
    friends = ['One', 'Two', 'Three'];
    console.log(organizeGiftExchange(shuffle(friends)));

    // arrays of length <= 2 won't be processed
    friends = ['One', 'Two'];
    console.log(organizeGiftExchange(shuffle(friends)));   
}

// run the tester and see some output
tester();

// output:

/*
[LOG]: Five gives a gift to Four 
[LOG]: Four gives a gift to Three 
[LOG]: Three gives a gift to Two 
[LOG]: Two gives a gift to One 
[LOG]: One gives a gift to Five 
[LOG]:  
[LOG]: One gives a gift to Five 
[LOG]: Five gives a gift to Two 
[LOG]: Two gives a gift to Four 
[LOG]: Four gives a gift to Three 
[LOG]: Three gives a gift to One 
[LOG]:  
[LOG]: Two gives a gift to Five 
[LOG]: Five gives a gift to Three 
[LOG]: Three gives a gift to Four 
[LOG]: Four gives a gift to One 
[LOG]: One gives a gift to Two 
[LOG]:  
[LOG]: Three gives a gift to Two 
[LOG]: Two gives a gift to One 
[LOG]: One gives a gift to Three 
[LOG]:  
[LOG]: Sorry, not enough friends to exchange gifts with! 
[LOG]:  
*/
