alert('SceneScene1.js loaded');

function SceneScene1() {
	this.selectedIndex=0;
};

SceneScene1.prototype.initialize = function () {
	alert("SceneScene1.initialize()");
	// this function will be called only once when the scene manager show this scene first time
	// initialize the scene controls and styles, and initialize your variables here
	// scene HTML and CSS will be loaded before this function is called
};

SceneScene1.prototype.handleHide = function () {
	alert("SceneScene1.handleHide()");
	// this function will be called when the scene manager hide this scene
};

SceneScene1.prototype.handleFocus = function () {
	alert("SceneScene1.handleFocus()");
	// this function will be called when the scene manager focus this scene
};

SceneScene1.prototype.handleBlur = function () {
	alert("SceneScene1.handleBlur()");
	// this function will be called when the scene manager move focus to another scene from this scene
};

SceneScene1.prototype.selectItem = function(index){
	alert("#noticia"+index);
	$("#noticia"+index).toggleClass('focus');
	this.selectedIndex=index;
};

SceneScene1.prototype.handleShow = function (index) {
	alert("Show de scene1 con data "+index);
	if(index){
		this.selectItem(index);
	}else{
		this.selectItem(0);
	}
};

SceneScene1.prototype.handleKeyDown = function (keyCode) {
	alert("Entra "+keyCode);
	// TODO : write an key event handler when this scene get focused
	switch (keyCode) {
	case sf.key.UP:
		if(this.selectedIndex==0){
		$("#noticia"+0).toggleClass('focus');
		this.selectItem($('.divListItem').size()-1);
	}else{
		$("#noticia"+this.selectedIndex).toggleClass('focus');
		var newSelectedIndex=this.selectedIndex-1;
		this.selectItem(newSelectedIndex);
		}
	break;
	case sf.key.DOWN:
		if(this.selectedIndex==($('.divListItem').size()-1)){
		$("#noticia"+($('.divListItem').size()-
		1)).toggleClass('focus');
		this.selectItem(0);
	}else{
		$("#noticia"+this.selectedIndex).toggleClass('focus');
		var newSelectedIndex=this.selectedIndex+1;
		this.selectItem(newSelectedIndex);
	}
	break;
	case sf.key.ENTER:
		$("#noticia"+this.selectedIndex).toggleClass('focus');
		sf.scene.hide('Scene1');
		alert("muestro el scene second con index" +this.selectedIndex);
		sf.scene.show('Second',this.selectedIndex);
		sf.scene.focus('Second');
	break;
	default:
		alert("Tecla no manejada");
	break;
	}
};
	
SceneSecond.prototype.handleShow = function (data) {
	alert("HandleShow con data "+data);
	this.activeIndex=data;
	$("#showDivId").html("Este es el contenido de la noticia" +(this.activeIndex*1+1));
	// this function will be called when the scene manager show this scene
};