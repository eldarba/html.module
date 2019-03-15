/**
 * 
 */
"use strict";
function Animal() {
}
Animal.prototype.speak = function() {
	return "speak like an animal";
};

function Mammal() {
	Animal.call(this);
}
Mammal.prototype = Object.create(Animal.prototype);
Mammal.prototype.constructor = Mammal;

function Bird() {
	Animal.call(this);
}
Bird.prototype = Object.create(Animal.prototype);
Bird.prototype.constructor = Bird;

function Insect() {
	Animal.call(this);
}
Insect.prototype = Object.create(Animal.prototype);
Insect.prototype.constructor = Insect;

function Cow() {
	Mammal.call(this);
}
Cow.prototype = Object.create(Mammal.prototype);
Cow.prototype.constructor = Cow;
Cow.prototype.speak = function() {
	return "speak like a cow";
};

function Bat() {
	Mammal.call(this);
}
Bat.prototype = Object.create(Mammal.prototype);
Bat.prototype.constructor = Bat;
Bat.prototype.speak = function() {
	return "speak like a bat";
};

function Ostrich() {
	Bird.call(this);
}
Ostrich.prototype = Object.create(Bird.prototype);
Ostrich.prototype.constructor = Ostrich;
Ostrich.prototype.speak = function() {
	return "speak like an ostrich";
};

function Sparrow() {
	Bird.call(this);
}
Sparrow.prototype = Object.create(Bird.prototype);
Sparrow.prototype.constructor = Sparrow;
Sparrow.prototype.speak = function() {
	return "speak like a sparrow";
};

function Butterfly() {
	Insect.call(this);
}
Butterfly.prototype = Object.create(Insect.prototype);
Butterfly.prototype.constructor = Butterfly;
Butterfly.prototype.speak = function() {
	return "speak like a butterfly";
};

function Ant() {
	Insect.call(this);
}
Ant.prototype = Object.create(Insect.prototype);
Ant.prototype.constructor = Ant;
Ant.prototype.speak = function() {
	return "speak like an ant";
};

(function() {
	console.log("=== start ===");

	var animals = new Array(6);

	animals[0] = new Ant();
	animals[1] = new Bat();
	animals[2] = new Butterfly;
	animals[3] = new Cow()
	animals[4] = new Ostrich();
	animals[5] = new Sparrow();

	for ( var i in animals) {
		console.log(animals[i]);
		console.log(animals[i].speak());
	}

	console.log("=== end =====");
})();
