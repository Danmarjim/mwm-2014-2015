alert('SceneSecond.js loaded');

function SceneSecond() {

};

SceneSecond.prototype.initialize = function () {
	alert("SceneSecond.initialize()");
	// this function will be called only once when the scene manager show this scene first time
	// initialize the scene controls and styles, and initialize your variables here
	// scene HTML and CSS will be loaded before this function is called

};

SceneSecond.prototype.handleShow = function (data) {
	alert("SceneSecond.handleShow()");
	this.activeIndex=data;
	$("#showDivId").html("Este es el contenido de la noticia" +(this.activeIndex*1+1));
	// this function will be called when the scene manager show this scene
};

SceneSecond.prototype.handleHide = function () {
	alert("SceneSecond.handleHide()");
	// this function will be called when the scene manager hide this scene
};

SceneSecond.prototype.handleFocus = function () {
	alert("SceneSecond.handleFocus()");
	// this function will be called when the scene manager focus this scene
};

SceneSecond.prototype.handleBlur = function () {
	alert("SceneSecond.handleBlur()");
	// this function will be called when the scene manager move focus to another scene from this scene
};

SceneSecond.prototype.handleKeyDown = function (keyCode) {
	alert("SceneSecond.handleKeyDown(" + keyCode + ")");
	switch (keyCode) {
	case sf.key.RETURN:
		alert("Entro en return con index "+this.activeIndex);
		sf.scene.hide('Second');
		sf.scene.show('Scene1', this.activeIndex);
		sf.scene.focus('Scene1');
		sf.key.preventDefault();
	break;
	default:
		alert("Tecla no manejada");
	break;
	}
};
