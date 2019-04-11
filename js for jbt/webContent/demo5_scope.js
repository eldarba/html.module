/**
 * 
 */
 "use strict";
 // hoisting
x = 5;
console.log(x);
var x;

// get-only property
var person = {
	age : 25,
	// define a get-only property
	get throwNum(){
		return Math.floor(Math.random() * 121);
	}
};

// define a read-only property
Object.defineProperty(person, "id", {
	value : 101,
	writable : false
});
// define a property
Object.defineProperty(person, "name", {
	value : "James",
	writable : true
});

console.log(person);
person.name = "Ron";
console.log(person);
console.log("throwing a random number: " + person.throwNum);

var rectangle = {
		length:0,
		width:0,
		get area(){
			return this.length * this.width;
		}
};
console.log(rectangle);
console.log("area : " + rectangle.area);
rectangle.length = 4;
rectangle.width= 5;
console.log(rectangle);
console.log("area : " + rectangle.area);
