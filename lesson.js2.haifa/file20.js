"use strict";
var x = 5; // global scope

function f1(){
	var y = 10; // function scope
	{
		let z = 15;
	}
	const pi = 3.14;
	// pi++; // error
	console.log(pi);
	
	console.log(10 == "10"); // true
	console.log(10 === "10"); // false
}