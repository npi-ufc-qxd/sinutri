// Modifique o valor para mostrar ou não logs na tela
var DEBUG = true;


if (DEBUG) {

	var sn_log = console.log.bind(window.console);
	var sn_error = console.error.bind(window.console);

} else {
	
	var sn_log = function() {};
	var sn_error = function() {};

}

$(document).ready(function() {

	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		
		sn_base.doInit();
		sn_parallax_background.doInit();
			
	});

});


jQuery.fn.exists = function() { return this.length > 0; }


var tryExecute = function(func, prefix, successMessage, errorMessage) {
	
	try {
	    
	    var res = func();
	    sn_log(prefix + " - " + successMessage);
	    return res;

	} catch(err) {

		sn_error(prefix + " - " + errorMessage + " [" + err + "]");
		return null;

	}
	
}

var sn_base = function() {

	var dialogCounter = 0;

	var setupForm = function(root) {

		root = root == undefined? "body": root;

		if($(root + " .sn-date-picker").exists()) { 

			$(root + " .sn-date-picker").each(function(index, el) {
				el = $(el);
				var id = el.attr("id");
				if (id == undefined) {
					el.attr("id", "sn-date-picker-" + index);
				}
				var selector = "#" + id;
				sn_base.doRegistryDatePicker(selector, $(root));
			});

		}

		if($(root + " .sn-time-picker").exists()) { 

			$(root + " .sn-time-picker").each(function(index, el) {
				el = $(el);
				var id = el.attr("id");
				if (id == undefined) {
					el.attr("id", "sn-time-picker-" + index);
				}
				var selector = "#" + id;
				sn_base.doRegistryTimePicker(selector, $(root));
			});

		}

		if($(root + " .sn-date-time-picker").exists()) { 

			$(root + " .sn-date-time-picker").each(function(index, el) {
				el = $(el);
				var id = el.attr("id");
				if (id == undefined) {
					el.attr("id", "sn-date-time-picker-" + index);
				}
				var selector = "#" + id;
				sn_base.doRegistryDateTimePicker(selector, $(root));
			});

		}
		
	}
	
	var setupScrollEvents = function() {

		$(".mdl-layout__content").scroll(function() {

			scrollTop = $(this).scrollTop();
			if(scrollTop > 8)
				$(".mdl-layout__header").css("box-shadow", "0 2px 2px 0 rgba(0,0,0,.14),0 3px 1px -2px rgba(0,0,0,.2),0 1px 5px 0 rgba(0,0,0,.12)");
			else 
				$(".mdl-layout__header").css("box-shadow", "none");				

		});
		$(".mdl-layout__header").css("box-shadow", "none");

		$(".mdl-layout__content").scroll(function() {

			$(".sn-rear-track").css("top", "-" + ($(this).scrollTop()*0.5) + "px");

		});

	}

	var setupDialog = function(dialogSelector) {

		
	}

	var setupDrawer = function() {

		var hb = $($.parseHTML(
			"<button class=\"sn-btn-hanburger sn-btn-hanburger-hidden mdl-js-ripple-effect\">" + 
				  "<i class=\"material-icons\">menu</i>" + 
				  "<span class=\"mdl-ripple\"></span>" + 
			"</button>"
		));

		var hbHidden = $($.parseHTML(
			"<button class=\"sn-btn-hanburger sn-btn-hanburger-inverse mdl-js-ripple-effect\">" + 
				  "<i class=\"material-icons\">menu</i>" + 
				  "<span class=\"mdl-ripple\"></span>" + 
			"</button>"
		));

		hb.click(function() {

			toggleDrawer();

		});

		hbHidden.click(function() {

			toggleDrawer();

		});

		$(".mdl-layout__header").prepend(hb);
		$(".sn-drawer-left").prepend(hbHidden);

		$(".sn-main__foreground").click(toggleDrawer);

	}

	var toggleDrawer = function() {

		$("*").removeClass("sn-no-animation");	    

		var drawer = $(".sn-drawer-left");
		drawer.toggleClass("sn-drawer-left-closed");

		var main = $(".sn-main");
		main.toggleClass("sn-main-expanded");

		$(".sn-btn-hanburger").toggleClass("sn-btn-hanburger-hidden");

		$(".sn-main__foreground").toggleClass("sn-main__foreground-hidden");

	}

	var showContent = function() {

		$(".sn-foreground").fadeOut(500);

	}

	var sortDivs = function() {

		var items = $("body").children();

		items.sort(function (a, b) {
			var contentA = $(a).hasClass("dtp")? 3: $(a).hasClass("mdl-dialog")? 2: 1;
			var contentB = $(b).hasClass("dtp")? 3: $(b).hasClass("mdl-dialog")? 2: 1;
			return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
	   	});

	   	items.each(function(i, el) {
	   		$(el).parent().append(el);
	   	});
	}
	
	var setupFab = function() {
		$(".sn-float--launcher").click(function() {
			$(".sn-float--launcher").parent().find(".sn-fab").toggleClass("sn-fab--hide");
		});
	}

	return {

		doInit : function() {

			tryExecute(setupForm, "sn_base", "Setup form done!", "Setup form error!");
			tryExecute(setupScrollEvents, "sn_base", "Setup scroll events done!", "Setup scroll events error!");
			tryExecute(setupDrawer, "sn_base", "Setup drawer done!", "Setup drawer error!");

			tryExecute(toggleDrawer, "sn_base", "Toggle drawer done!", "Toggle drawer error!");

			tryExecute(showContent, "sn_base", "Show content done!", "Show content error!");	

			tryExecute(setupFab, "sn_base", "Setup Fab done!", "Setup Fab error!");	

		}, 

		doRegistryDialog : function(setts) {

			var dialogText="" + 
				"<dialog class=\"mdl-dialog\" id=\"modal-1\">" + 

					"<div class=\"mdl-card__menu\">" + 
						"<button class=\"mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect mdl-card__menu-close\">" + 
							"<i class=\"material-icons\">close</i>" + 
						"</button>" + 
					"</div>" + 

					"<h4 class=\"mdl-dialog__title\"></h4>" + 
					"<div class=\"mdl-dialog__content\">" + 
						// ...
					"</div>" + 
					"<div class=\"mdl-dialog__actions\">" + 
						// ...
					"</div>" +

				"</dialog>";

			var dialog = $($.parseHTML(dialogText));
			var dialogContent = $(setts.dialog);
			dialogContent.remove();

			dialog.attr("id", "sn-dialog-" + (dialogCounter++));
			
			$("body").append(dialog);	
			
			dialog.find(".mdl-dialog__content").append(dialogContent);
			dialog.find(".mdl-card__menu-close").click(function() { dialog.get(0).close(); });
			dialog.find(".mdl-dialog__title").text(setts.title);

			if(setts.buttons !== undefined)
				for(var i = 0; i < setts.buttons.length; i++) {
					
					var index = parseInt(JSON.stringify(i));
					//var bs = setts.buttons[i];
					var bs = setts.buttons[index];
					var button = $.parseHTML("<a class=\"mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--primary\">" + bs.label + "</a>");
					//$(button).click(bs.action);
					$(button).click(bs.action);
					dialog.find(".mdl-dialog__actions").append(button);
					for(k in bs.attrs)
						$(button).attr(k, bs.attrs[k]);		

				}

			if (!dialog.get(0).showModal) {
				dialogPolyfill.registerDialog(dialog.get(0));
			}

			$(setts.showButton).click(function() {
				dialog.get(0).showModal();
			});

			dialog.find("*").each(function(i, el) {
				componentHandler.upgradeElement(el);
			});

			setupForm("#" + dialog.attr("id"));

			sortDivs();

			return dialog.get(0);


		}, 

		doRegistryDatePicker : function(el, root) {

			if(root === undefined) root = $("body");
			if($(el).exists()) {

				$(el).bootstrapMaterialDatePicker({
					format: "DD/MM/YYYY", 
					shortTime: false, 
					date: true, 
					time: false, 
					currentDate: new Date(), 
					nowButton: true, 
					cancelText: "Cancelar", 
					okText: "OK", 
					nowText: "Agora", 
					parent: root
				});

			}

			sortDivs();

		}, 

		doRegistryTimePicker : function(el, root) {

			if(root === undefined) root = $("body");
			if($(el).exists()) {

				$(el).bootstrapMaterialDatePicker({
					format: "HH:mm", 
					shortTime: false, 
					date: false, 
					time: true, 
					currentDate: new Date(), 
					nowButton: true, 
					cancelText: "Cancelar", 
					okText: "OK", 
					nowText: "Agora", 
					parent: root
				});

			}

			sortDivs();

		}, 

		doRegistryDateTimePicker : function(el, root) {

			if(root === undefined) root = $("body");
			if($(el).exists()) {

				$(el).bootstrapMaterialDatePicker({
					format: "DD/MM/YYYY HH:mm", 
					shortTime: false, 
					date: true, 
					time: true, 
					currentDate: new Date(), 
					nowButton: true, 
					cancelText: "Cancelar", 
					okText: "OK", 
					nowText: "Agora", 
					parent: root
				});

			}

			sortDivs();

		}

	};

} ();


var sn_parallax_background = function() {

	// Guarda o último valor da cor de background
	// Necessário porque alguns navegadores substituem o rgba(0, 0, 0, 0) por transparent
	var lastRGBA = "rgba(0, 0, 0, 0)";

	// Altura da imagem de background
	var headerImageHeight = 0.0;

	// Função que calcula a altura da imagem de background
	var headerHeightFunction = function () {

		// A altura da imagem é calculada com base na largura, estabelecendo
		// um aspecto de 16:9
		headerImageHeight = $(window).width() * 9.0 / 16.0 * 0.6;

	}

	// Função que deixa o header transparente ou não com base na rolagem da página
	var scrollFunction = function () {
		
	    var scroll = $(".mdl-layout__content").scrollTop();

	    $("*").addClass("sn-no-animation");
	    $(".sn-header-image__background").css('background-position', '0px ' + (-scroll * 0.5) + "px");

	    var opacity = scroll > headerImageHeight * 0.5?
	    	((scroll - headerImageHeight*0.8) / (headerImageHeight * 0.2)):
	    	0;

	    if(opacity > 1) 
	    	opacity = 1;

	    var rawRgb = $(".mdl-layout__header").css("background-color");

	    if(rawRgb == "transparent")
	    	rawRgb = lastRGBA;

	    rgb = rawRgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);

	    if(rgb == null) {

	    	rgb = rawRgb.substring(rawRgb.indexOf('(') + 1, rawRgb.lastIndexOf(')')).split(/,\s*/);
	    	var rgba = "rgba(" + rgb[0] + ", " + rgb[1] + ", " + rgb[2] + ", " + opacity + ")";
	    	$(".mdl-layout__header").css("backgroundColor", rgba);
	    	lastRGBA = rgba;

	    } else {

	    	var rgba = "rgba(" + rgb[1] + ", " + rgb[2] + ", " + rgb[3] + ", " + opacity + ")";
	    	$(".mdl-layout__header").css("backgroundColor", rgba);
	    	lastRGBA = rgba;

	    }

	    if(opacity < 1)
	    	$(".mdl-layout__header").css("box-shadow", "none");
	    else
			$(".mdl-layout__header").css({ boxShadow : "0 2px 2px 0 rgba(0,0,0,.14),0 3px 1px -2px rgba(0,0,0,.2),0 1px 5px 0 rgba(0,0,0,.12)" });

	    if($(".sn-header__fab").exists()) {
	    	if(opacity >= 1) {
	    		console.log("To 1");
	    		$(".sn-header__fab").fadeIn();
	    	} else {
	    		console.log("To 0");
	    		$(".sn-header__fab").fadeOut();
	    	}
	    }

	};


	return {

		doInit : function() {

			if($(".sn-parallax-background").exists()) {

				headerHeightFunction();
				scrollFunction();

				// Iniciando stellar, plugin para paralaxe na imagem de fundo
				$(".mdl-layout__content").scroll(scrollFunction);

				// Setando altura apropriada para o frame de referencia 
				$(".sn-header-image__frame").height( headerImageHeight );
				$(window).resize(function() {
					headerHeightFunction();
					scrollFunction();
					$(".sn-header-image__frame").height( headerImageHeight );
				});

				$(".mdl-layout__content").animate({
			        scrollTop: headerImageHeight * 0.8
			    }, 800);

			}

		}

	};

} ();



// Método atribuído ao namespace do JQuery para criação de DynamicList's
jQuery.fn.dynamicList = function(settings) {

	// Criação de um novo objeto do tipo DynamicList
	return new DynamicList($(this), settings).doInit();

}

// Método atribuído ao namespace do JQuery para verificar se o objeto já contém 
// a atribuição de uma DynamicList
jQuery.fn.isDynamicList = function(settings) {

	return $(this).data("dynamic-list-settings") !== undefined;

}


// Classe responsável por guardar métodos e atributos do componente DynamicList

var DynamicList = function(rootEl, settings) {

	// Configurações da lista dinâmica

	this.DEFAULT_SETTINGS = {

		// Seletor do elemento que será clonado
		cloneableElement: ".dl-el", 

		// Seletor do botão responsável por adicionar novos items
		addButton: ".dl-add", 
		// Seletor do botão responsável por remover items
		removeButton: ".dl-el-remove", 
		// Seletor do botão responsável por editar items
		editButton: ".dl-el-edit", 

		// Indica se os atributos terão o id incrementado automaticamente.
		// Nesse caso, um id "elemento-0" sera incrementado para "elemento-1" e
		// assim por diante
		autoIncrementID: true, 
		autoIncrementName: true, 

		// Indica se o primeiro elemento da lista será mostrado ou não
		hideFirst: true,
		// Indica a forma de display padrão para cada elemento da lista
		defaultItemDisplay: "block",

		// Trás os valores padrão para os elementos da lista
		defaultData: {}, 

		// Lista de callbacks
		// Para que o item seja adicionado, removido ou editado, retorne true
		onItemAdd: function(item) { return true; }, 
		onItemAdded: function(item) {}, 
		onItemRemove: function(item) { return true; }, 
		onItemRemoved: function(item) {}, 
		onItemEdit: function(item) { return true; },
		onItemEdited: function(item) {},
		
	};

	this.rootEl = rootEl;
	this.parent = undefined;
	this.settings = settings;
	this.template = undefined;

	this.error = function(message) {

		console.error("Dynamic HTML: " + message);

	}

	this.log = function(message) {

		console.log("Dynamic HTML: " + message);

	}

	this.showStatus = function(message) {

		// console.log(this.parent.attr("id") + " - " + message + " - Elements: " + parent.children(this.settings.cloneableElement).length);

	}

	this.getNextAttrBy = function(attr) {

		var attrs = attr.split("-");
		var index = attrs[attrs.length - 1];

		if($.isNumeric(index)) {

			var index = parseInt(index) + 1;
			var newAttr = "" + index;
			for(var i = attrs.length - 2; i >= 0; i--)
				newAttr = attrs[i] + "-" + newAttr;

			return newAttr;

		}

		return attr;

	}

	this.doIncrementItem = function(name, index) {
		
		if( /[\w]+\[[\d]+\]\.[\w]+/.test(name) ) {
			return name.replace( /\[[\d]+\]+/, "[" + index + "]")
		} 

		return name;

	}

	this.sortItems = function() {
		var items = $(this.settings.cloneableElement);
		items.sort(function (a, b) {
			var contentA = parseInt( $(a).data('sort'));
			var contentB = parseInt( $(b).data('sort'));
			return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
	   	});

	   	var self = this;
	   	items.each(function(i, e) {
	   		var index = parseInt(JSON.stringify(i));

	   		$(e).data("index", index);
	   		$(e).parent().append(e);

			var setSetupFunc = function(rootEl) {

				rootEl.children().each(function(_, elm) {
					
					var el = $(elm);

					if(!el.isDynamicList()) {

						el.attr("name", self.doIncrementItem(el.attr("name"), index));
						setSetupFunc(el);

					}

				});

			}

			$(e).attr("name", self.doIncrementItem($(e).attr("name"), index));
			setSetupFunc($(e));

	   	});
	}

	/* PUBLIC */

	this.doInit = function() {

		DynamicList.objectCount++;

		var self = this;

		if(self.rootEl.length == 0) 
			self.error("O elemento especificado como container não existe!");

		if(self.settings === undefined)
			self.settings = this.DEFAULT_SETTINGS;

		else
			for(k in self.DEFAULT_SETTINGS)
				if(self.settings[k] === undefined)
					self.settings[k] = self.DEFAULT_SETTINGS[k];


		self.rootEl.data("dynamic-list-id", DynamicList.objectCount);
		self.rootEl.data("dynamic-list-settings", self.getSettings());

		self.parent = $(self.rootEl.find(self.settings.cloneableElement).get(0)).parent();
		var items = self.parent.children(self.settings.cloneableElement);
		
		if(items.length == 0) {

			self.error("Você precisa de pelo menos um item para clonar!");

		} else {

			var item = $(items.get(0));	
			item.remove();
			self.template = item;
			self.settings.defaultItemDisplay = item.css("display");

			if(self.settings.hideFirst) {

				item.css("display", "none");

			} else {
				
				var setRemoveFunc = function(rootEl) {

					rootEl.children(self.settings.removeButton).each(function(index, el) {
						
						if(!$(el).isDynamicList()) {

							$(el).click(function() {

								if(self.settings.onItemRemove(rootEl))
									self.doRemoveItem(rootEl);
								
							});

							setRemoveFunc($(el));

						}

					});

				}

				setRemoveFunc(item);

			}

		}

		var setAddFunc = function(rootEl) {

			rootEl.children(self.settings.addButton).each(function(index, el) {
				
				$(el).click(function() {

					var data = self.settings.onItemAdd();
					if(data != undefined && data !== false)
						self.doAddItem(data);
					
				});

			});

			rootEl.children().each(function(index, el) {
				if(!$(el).isDynamicList()) {
					setAddFunc($(el));
				}
			});

		}

		setAddFunc(self.rootEl);

		self.sortItems();

		self.showStatus("Initializing");

		return this;

	}

	this.doAddItem = function(data) {
		
		var self = this;

		var items = this.parent.children(this.settings.cloneableElement);
		
		if(self.template !== undefined) {
			
			var last = items.length == 0? undefined: items.last();
			var newItem = self.template.clone(true);
			newItem.find("*").off("click");

			if(last === undefined)
				self.parent.append(newItem);
			else 
				newItem.insertAfter(last);

			newItem.css("display", self.settings.defaultItemDisplay);

			var setSetupFunc = function(rootEl) {

				rootEl.children().each(function(index, elm) {
					
					var el = $(elm);

					if(el.isDynamicList()) {

						var settings = el.data("dynamic-list-settings");
						var dl = el.dynamicList(settings);
						dl.doClearItems();

					} else {

						setSetupFunc(el);

					}

				});

			}

			setSetupFunc(newItem);

			var setRemoveFunc = function(rootEl) {

				rootEl.children(self.settings.removeButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemRemove(newItem))
							self.doRemoveItem(newItem);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setRemoveFunc($(el));
					}

				});

			}

			setRemoveFunc(newItem);

			var setEditFunc = function(rootEl) {

				rootEl.children(self.settings.editButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemEdit(newItem, newItem.data("index")))
							self.doEditItem(newItem);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setEditFunc($(el));
					}

				});

			}

			setEditFunc(newItem);

			if(data === undefined)
				data = self.settings.defaultData;
			
			for(k in data) {

				var el = newItem.find(k);
				var elData = data[k];
				for(attr in elData) {

					if(attr === "value")
						el.val(elData[attr]);
					else if(attr === "text")
						el.text(elData[attr]);
					else
						el.attr(attr, elData[attr]);

				}

			}

			newItem.data("sort", data.sortValue);
			

		} else {

			self.error("Nenhum elemento com o seletor " + self.settings.cloneableElement + " foi encontrado!");

		}

		componentHandler.upgradeElement(newItem.get(0));
		newItem.find("*").each(function() {
			
			componentHandler.upgradeElement(this);

		});

		componentHandler.upgradeDom();

		self.settings.onItemAdded(newItem);

		self.showStatus("Adding");

		self.sortItems();

		newItem.css("min-height", "0");
		newItem.css("min-width", "0");
		newItem.css("border-radius", "50px");
		newItem.css("width", "72px");
		var anim = new Animation(newItem).doSequentially(
			new Animation().doAnimate(
				{"width": "100%", specialEasing: {width: "linear"}},
				{duration: 200, queue: false}
			), 
			new Animation().doAnimate(
				{"border-radius": "2px", specialEasing: {"border-radius": "linear"}},
				{duration: 50, queue: false}
			)
		).doPlay();

		return newItem;
		
	} 

	this.doRemoveItem = function(item) {

		var self = this;
		var items = self.parent.children(self.settings.cloneableElement);

		if(items.length > 0) {

			el = item;
				
			el.css("min-height", "0px");
			el.css("min-width", "0px");
			el.css("margin-left", "auto");
			
			var anim = new Animation(el).doSequentially(
				new Animation().doAnimate(
					{"border-radius": "50px", specialEasing: {"border-radius": "linear"}},
					{duration: 100, queue: false}
				),
				new Animation().doAnimate(
					{width: "72px", height: "72px", specialEasing: {width: "linear"}},
					{duration: 100, queue: false}
				),
				new Animation().doAnimate(
					{width: "0px", height: "0px", specialEasing: {width: "linear"}},
					{duration: 50, queue: false}
				)
				
			).doPlay();

			setTimeout(function() {
				item.find("*").remove();
				item.remove();
				self.settings.onItemRemoved(item);
				self.sortItems();
			}, 250);		

		}

		self.showStatus("Removing");

	}

	this.doEditItem = function(index, data) {

		var self = this;
		var item = $(self.parent.children(self.settings.cloneableElement)[index]);

		for(k in data) {

			var el = item.find(k);
			var elData = data[k];
			for(attr in elData) {

				if(attr === "value")
					el.val(elData[attr]);
				else if(attr === "text")
					el.text(elData[attr]);
				else
					el.attr(attr, elData[attr]);

			}

		}

		item.data("sort", data.sortValue);

		this.sortItems();

		var anim = new Animation(item).doSequentially(
			new Animation().doAnimate(
				{"margin-left": "-16px", specialEasing: {"margin-left": "linear"}},
				{duration: 100, queue: false}
			), 
			new Animation().doAnimate(
				{"margin-left": "16px", specialEasing: {"margin-left": "linear"}},
				{duration: 100, queue: false}
			), 
			new Animation().doAnimate(
				{"margin-left": "-16px", specialEasing: {"margin-left": "linear"}},
				{duration: 100, queue: false}
			), 
			new Animation().doAnimate(
				{"margin-left": "0px", specialEasing: {"margin-left": "linear"}},
				{duration: 100, queue: false}
			)
		).doPlay();

		return item;

	}

	this.doClearItems = function() {
		
		var self = this;
		self.parent.children(self.settings.cloneableElement).each(function(i, el) {

			if(i > 0) 
				self.doRemoveItem($(this));
			
		});

		self.showStatus("Clearing");

	} 

	this.getSettings = function() {

		var settings = JSON.parse(JSON.stringify(this.settings));
		settings.onItemAdd = undefined;
		settings.onItemAdded = undefined;
		settings.onItemRemove = undefined;
		settings.onItemRemoved = undefined;
		settings.onItemEdit = undefined;
		settings.onItemEdited = undefined;
		return settings;

	}

};

DynamicList.objectCount = 0;


var Animation = function(el) {

	this.el = el;
	this.anim = null;

	this.doAnimate = function(setts, duration) {
		
		var data = {
			type: "animation", 
			setts: setts, 
			duration: duration
		};

		this.anim = data;

		return this;
	};

	this.doSequentially = function() {

		var data = {
			type: "sequentially", 
			anims: []
		};

		for(var i = 0; i < arguments.length; i++)
			data.anims.push(arguments[i].anim);

		this.anim = data;

		return this;

	};

	this.doPlay = function(onComplete) {

		this._play(this.anim, onComplete);
		return this;

	}

	this._play = function(anim, onComplete) {

		var _self = this;

		if(anim.type === "animation") {

			anim.duration.complete = function() {
				if(onComplete != undefined)
					onComplete();
			};

			_self.el.animate(
				anim.setts, 
				anim.duration				
			);

		} else if(anim.type === "sequentially") {

			if(anim.anims.length > 0) {
				var a = anim.anims.splice(0, 1)[0];
				_self._play(a, function() {

					if(onComplete != undefined)
						onComplete();

					_self._play(anim);

				});
			}
			
		} 

	}

};