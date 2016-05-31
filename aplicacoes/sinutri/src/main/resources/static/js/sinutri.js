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

	var setupForm = function() {
		
		if($(".sn-mask-date").exists()) {

			$(".sn-mask-date").mask("99/99/9999",{placeholder:"dd mm aaaa"});

		}

		if($(".sn-mask-phone").exists()) {

			$(".sn-mask-phone").mask("(99) 99999-9999");

		}

		if($(".sn-date-picker").exists()) { 

			$(".sn-date-picker").each(function(index, el) {
				el = $(el);
				var id = el.attr("id");
				if (id == undefined) {
					el.attr("id", "sn-date-picker-" + index);
				}
				var selector = "#" + id;
				sn_base.doRegistryDatePicker(selector);
			});

		}

		if($(".sn-time-picker").exists()) { 

			$(".sn-time-picker").each(function(index, el) {
				el = $(el);
				var id = el.attr("id");
				if (id == undefined) {
					el.attr("id", "sn-time-picker-" + index);
				}
				var selector = "#" + id;
				sn_base.doRegistryTimePicker(selector);
			});

		}

		if($(".sn-date-time-picker").exists()) { 

			$(".sn-date-time-picker").each(function(index, el) {
				el = $(el);
				var id = el.attr("id");
				if (id == undefined) {
					el.attr("id", "sn-date-time-picker-" + index);
				}
				var selector = "#" + id;
				sn_base.doRegistryDateTimePicker(selector);
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
	
	return {

		doInit : function() {

			tryExecute(setupForm, "sn_base", "Setup form done!", "Setup form error!");
			tryExecute(setupScrollEvents, "sn_base", "Setup scroll events done!", "Setup scroll events error!");
			tryExecute(setupDrawer, "sn_base", "Setup drawer done!", "Setup drawer error!");

			tryExecute(toggleDrawer, "sn_base", "Toggle drawer done!", "Toggle drawer error!");

			tryExecute(showContent, "sn_base", "Show content done!", "Show content error!");			

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

			for(var i = 0; i < setts.buttons.length; i++) {
				var bs = setts.buttons[i];
				button = $.parseHTML("<button class=\"mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--primary\">" + bs.label + "</button>");
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

			return dialog.get(0);


		}, 

		doRegistryDatePicker : function(el) {

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
					nowText: "Agora"
				});

			}

		}, 

		doRegistryTimePicker : function(el) {

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
					nowText: "Agora"
				});

			}

		}, 

		doRegistryDateTimePicker : function(el) {

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
					nowText: "Agora"
				});

			}

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

	this.sortItems = function() {
		var items = $(this.settings.cloneableElement);
		items.sort(function (a, b) {
			var contentA = parseInt( $(a).data('sort'));
			var contentB = parseInt( $(b).data('sort'));
			console.log("Comparando: " + contentA + " : " + contentB);
			return (contentA < contentB) ? -1 : (contentA > contentB) ? 1 : 0;
	   	});

	   	var self = this;
	   	items.each(function(i, el) {
	   		$(el).data("index", i);
	   		$(el).parent().append(el);
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

		self.showStatus("Initializing");

		return this;

	}

	this.doAddItem = function(data) {
		
		var self = this;

		var items = this.parent.children(this.settings.cloneableElement);
		
		if(items.length > 0) {

			var last = items.last();
			var newItem = last.clone(true);
			newItem.find("*").off("click");
			newItem.insertAfter(last);

			newItem.css("display", self.settings.defaultItemDisplay);

			if(self.settings.autoIncrementID && newItem.attr("id") != undefined)
				newItem.attr("id", self.getNextAttrBy(newItem.attr("id")));

			if(self.settings.autoIncrementName && newItem.attr("name") != undefined)
				newItem.attr("name", self.getNextAttrBy(newItem.attr("name")));

			var setSetupFunc = function(rootEl) {

				rootEl.children().each(function(index, elm) {
					
					var el = $(elm);

					if(el.isDynamicList()) {

						var settings = el.data("dynamic-list-settings");
						var dl = el.dynamicList(settings);
						dl.doClearItems();

					} else {

						if(self.settings.autoIncrementID && el.attr("id") != undefined)
							el.attr("id", self.getNextAttrBy(el.attr("id")));

						if(self.settings.autoIncrementName && $(this).attr("name") != undefined)
							el.attr("name", self.getNextAttrBy(el.attr("name")));

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

		return newItem;
		
	} 

	this.doRemoveItem = function(item) {

		var self = this;
		var items = self.parent.children(self.settings.cloneableElement);

		if(items.length > 1) {
			item.find("*").remove();
			item.remove();
			self.settings.onItemRemoved(item);
		}

		self.showStatus("Removing");

		this.sortItems();

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