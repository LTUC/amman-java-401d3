// problem domain: the Seattle Kitten Rescue has tons of kittens who
// need good homes. One of the best ways to reach prospective adoptive
// homes is to have profiles for each kitten available on a website.
// There are hundreds of kittens, though, and only a few volunteers;
// it's too time-consuming to hand-code each kitten's profile on their
// website. They need a better way.

// Each kitten's profile should have:
// - name
// - random age assigned
// - a list of what they like (eg: cuddling, chasing string, napping, food)
// - an image
// good with kids
// good with dogs
// good with other cats
// breed (e.g: Egyptian Mau, Persian,British Shorthair)

// TODO: dynamically generate kitten objects using form data

var cats=[]; // array of objects

function Cat(name, likes, imagePath, goodWithKids, goodWithDogs, goodWithOtherCats, breed) {
  this.name = name;
  this.likes = likes;
  this.imagePath = imagePath;
  this.goodWithKids = goodWithKids;
  this.goodWithDogs = goodWithDogs;
  this.goodWithOtherCats = goodWithOtherCats;
  this.breed = breed;
  this.age = 0;
  cats.push(this);
}

Cat.prototype.getAge = function (min, max) {
  this.age = getRandomNumber(min, max);
}

Cat.prototype.render = function () {

  var container = document.getElementById("kittenProfiles");
  // create and append article to the container
  var articleEl = document.createElement("article");
  container.appendChild(articleEl);
  // create h2 with frankie name as textContent and append it to the article
  var h2El = document.createElement("h2");
  articleEl.appendChild(h2El);
  h2El.textContent = this.name; // or frankie.name
  // create p with frankie age string and append it to article
  var pEl = document.createElement("p");
  articleEl.appendChild(pEl);
  pEl.textContent = `${this.name} is adorable, and is ${this.age} months old.`;
  // create ul and append it to article
  var ulEl = document.createElement("ul");
  articleEl.appendChild(ulEl);
  pEl.textContent = `${this.likes}`;
  // create image and set the src attribute to frankie image path then append it to the article
  var imgEl = document.createElement("img");
  imgEl.setAttribute("src", this.imagePath);
  articleEl.appendChild(imgEl);

  // create table
  var tableE1 = document.createElement('table');
  container.appendChild(tableE1);

  var headerRow = document.createElement('tr');
  tableE1.appendChild(headerRow);

  var th1 = document.createElement('th');
  headerRow.appendChild(th1);
  th1.textContent = 'good With Kids';
  var th2 = document.createElement('th');
  headerRow.appendChild(th2);
  th2.textContent = 'good With Dogs';
  var th3 = document.createElement('th');
  headerRow.appendChild(th3);
  th3.textContent = 'good With Cats';

  var row2 = document.createElement('tr');
  tableE1.appendChild(row2);

  var td1 = document.createElement('td');
  row2.appendChild(td1);
  td1.textContent = this.goodWithKids;
  var td2 = document.createElement('td');
  row2.appendChild(td2);
  td2.textContent = this.goodWithDogs;
  var td3 = document.createElement('td');
  row2.appendChild(td3);
  td3.textContent = this.goodWithOtherCats;
  

}

var kittensForm = document.getElementById('kittensForm');

kittensForm.addEventListener('submit', addNewCat);

function addNewCat(event){
  event.preventDefault();
  
  var catNameValue = event.target.catName.value;
  console.log(catNameValue);

  var catLikesValue = event.target.likes.value;
  console.log(catLikesValue);

  var breedValue = event.target.breed.value;
  console.log(breedValue);

  var goodWithCatsValue = event.target.goodWithCats.checked;
  console.log(goodWithCatsValue);

  var goodWithDogsValue = event.target.goodWithDogs.checked;
  console.log(goodWithDogsValue);

  var goodWithKidsValue = event.target.goodWithKids.checked;
  console.log(goodWithKidsValue);

  var imagePath = `images/${catNameValue}.jpeg`;

  var newCat = new Cat(catNameValue, catLikesValue, imagePath, goodWithKidsValue,goodWithDogsValue,goodWithCatsValue, breedValue);
  newCat.getAge(1,10);
  newCat.render();

}

//Helper function
function getRandomNumber(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}



// name, likes, imagePath, goodWithKids, goodWithDogs, goodWithOtherCats, breed
// var frankie = new Cat (
//   'Frankie',
//   ["cuddling", "chasing string", "napping", "food"],
//   `images/frankie.jpeg`,
//   true,
//   false,
//   true,
//   "British Shorthair");


// var jumper = new Cat (
//   'Jumper',
//   ["cuddling","napping"],
//   `images/jumper.jpeg`,
//   false,
//   true,
//   false,
//   'Persian'
// );

// var serena = new Cat (
//   'Serena',
//   ["cuddling","napping", "chasing string"],
//   `images/serena.jpeg`,
//   true,
//   true,
//   false,
//   'Persian'
// );

// console.log(frankie);
// console.log(serena);
// console.log(jumper);
console.log(cats);


// frankie.getAge(1,11);
// frankie.render();
// serena.getAge(1,11);
// serena.render();
// jumper.getAge(1,11);
// jumper.render();
// var cats = [frankie,serena,jumper];
for(var i=0; i<cats.length;i++) {
  cats[i].getAge(1,11);
  cats[i].render();
  console.log(cats[i].name);
}



////////////////////////////////////////////////////////////////////
//1 create a constructor function for all cats

//2 add getAge method to the prototype

//3 add render method to the prototype

//4 creat 3 new instance of cats by using the new keyword

//5 add all cats in array

//6 loop through them and call the getAge and render methods

//7 do a repl.it for tables (table.html code is attached) then apply it in html



// table steps

// 1 create table

// 2 create first row

// 3 create second row

// 4 create the 3 table headers and assign values to the textContent

// 5 append the table headers to the first row

// 6 creat 3 table data and assign values to the textContent

// 7 append the table data to the second row

// 8 append the two rows to the table

// 9 append the table to the article


////////////////////////////////////////   
// <table>
//   <tr>
//     <th>good with cats</th>
//     <th>good with dogs</th>
//     <th>good with kids</th>
//   </tr>
//   <tr>
//     <td>true</td>
//     <td>true</td>
//     <td>false</td>
//   </tr>
// </table>