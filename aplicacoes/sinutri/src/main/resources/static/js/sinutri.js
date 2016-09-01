/* _sn-0-base.js */

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
		sn_toast.doInit();
		sn_inputmask.doInit();
			
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
	
	var setupSnackBar = function() {

		var sb = $.parseHTML("" + 
			"<div id=\"sn-snackbar\" class=\"mdl-js-snackbar mdl-snackbar\">" + 
				"<div class=\"mdl-snackbar__text\"></div>" + 
				"<button class=\"mdl-snackbar__action\" type=\"button\"></button>" + 
				"<div class=\"mdl-snackbar__icon\"><i class=\"material-icons\">add</i></div>" + 
			"</div>"
		);

		$("body").append(sb);

		componentHandler.upgradeElement(sb[0]);

		setTimeout(
			function() {

				$(".sn-messages").children().each(function(_, el) { 
					var text = $(el).text();
					var type = $(el).data("tipo");

					sb[0].MaterialSnackbar.showSnackbar({
						message: text + "<i>teste</i>"
					});
				});	

			}, 
			1000
		);
		
	}

	var setupTheme = function() {

		var classList = $("body").attr("class");
		var reg = /sn-theme-\w+-*\w*/;
		var reg2 = /sn-theme-/;
		if(reg.test(classList)) {
			
			var theme = classList.match(reg)[0].replace(reg2, "");
			$(".mdl-button, .mdl-layout-title, .mdl-layout__header, .dtp-date, .dtp-header, .dtp .selected").not(".sn-fab").each(function() {
				$(this)[0].className = $(this)[0].className.replace(/mdl-color-*(\w|\d)*-*(\w|\d)*-*(\w|\d)*/, '');	

				if($(this).hasClass("mdl-button--raised")) {
					$(this).addClass("mdl-color--" + theme);
					$(this).addClass("mdl-color-text--white");
				} else if($(this).hasClass("mdl-button")) {
					$(this).addClass("mdl-color-text--" + theme + "-600");
				} 

				if($(this).hasClass("mdl-layout__header") ||
					$(this).hasClass("selected") ||
					$(this).hasClass("dtp-date")) {
					$(this).addClass("mdl-color--" + theme);
				}

				if($(this).hasClass("dtp-header")) {
					$(this).addClass("mdl-color--" + theme + "-700");
				}

				if($(this).hasClass("mdl-layout-title") && !$(this).parent().hasClass("mdl-layout__header-row")) {
					$(this).addClass("mdl-color-text--" + theme + "-600");
					$(this).parent().addClass("mdl-color--white");
				}

			});

		}

		sn_log($(".selected").length);

	}

	var setupBreadCrumbs = function() {

		var breadIconTemplate = $($.parseHTML("<i class=\"sn-breadcrumbs__icon material-icons\">keyboard_arrow_right</i>"));

		$(".sn-breadcrumbs").each(function(index, _) {
			if(index < $(".sn-breadcrumbs").length - 1) {
				console.log(breadIconTemplate);
				$(breadIconTemplate.clone()).insertAfter($(this));
			}
		});

	}

	return {

		doInit : function() {

			tryExecute(setupForm, "sn_base", "Setup form done!", "Setup form error!");
			tryExecute(setupScrollEvents, "sn_base", "Setup scroll events done!", "Setup scroll events error!");
			tryExecute(setupDrawer, "sn_base", "Setup drawer done!", "Setup drawer error!");
			tryExecute(setupFab, "sn_base", "Setup Fab done!", "Setup Fab error!");	
			tryExecute(setupSnackBar, "sn_base", "Setup SnackBar done!", "Setup SnackBar error!");	
			tryExecute(setupTheme, "sn_base", "Setup Theme done!", "Setup Theme error!");	
			tryExecute(setupBreadCrumbs, "sn_base", "Setup BreadCrumbs done!", "Setup BreadCrumbs error!");	

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

			tryExecute(setupTheme, "sn_base", "Setup Theme done!", "Setup Theme error!");	

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

			tryExecute(setupTheme, "sn_base", "Setup Theme done!", "Setup Theme error!");	

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

			tryExecute(setupTheme, "sn_base", "Setup Theme done!", "Setup Theme error!");	

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

			tryExecute(setupTheme, "sn_base", "Setup Theme done!", "Setup Theme error!");	

		}

	};

} ();


/* _sn-1-animation.js */

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

/* _sn-2-dynamic-list.js */

//Método atribuído ao namespace do JQuery para criação de DynamicList's
jQuery.fn.dynamicList = function(settings) {

	// Criação de um novo objeto do tipo DynamicList
	return new DynamicList($(this), settings).doInit();

}

//Método atribuído ao namespace do JQuery para verificar se o objeto já contém 
//a atribuição de uma DynamicList
jQuery.fn.isDynamicList = function(settings) {

	return $(this).data("dynamic-list-settings") !== undefined;

}


//Classe responsável por guardar métodos e atributos do componente DynamicList

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
		// Seletor do botão responsável por clonar items
		cloneButton: ".dl-el-clone", 

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

		recurssiveIndex: 0, 

		// Lista de callbacks
		// Para que o item seja adicionado, removido ou editado, retorne true
		onItemAdd: function(item) { return true; }, 
		onItemAdded: function(item) {}, 
		onItemRemove: function(item) { return true; }, 
		onItemRemoved: function(item) {}, 
		onItemEdit: function(item) { return true; },
		onItemEdited: function(item) {},
		onItemClone: function(item) { return true; },
		onItemCloned: function(item) {},
		
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
		
		if(name) {
			var reStr = "[\\w\\d]+\\[)(\\d+)(\\][\.\\w\\d\\[\\]]*)";

			for(var i = 0; i < this.settings.recurssiveIndex; i++) {
				reStr = "[\\w\\d\\[\\]]+\\." + reStr;
			}
			reStr = "(" + reStr;

			regExp = new RegExp(reStr, 'g');

			if( regExp.test(name) ) {
				name = name.replace(regExp, "$1" + index + "$3")
			} 

		}

		return name;

	}

	this.sortItems = function() {
		console.log("Sorting items...");
		var items = $(this.parent.children(settings.cloneableElement));

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

				var setCloneFunc = function(rootEl) {

					rootEl.children(self.settings.cloneButton).each(function(index, el) {
						
						if(!$(el).isDynamicList()) {

							$(el).click(function() {

								if(self.settings.onItemClone(rootEl))
									self.doCloneItem(rootEl);
								
							});

							setCloneFunc($(el));

						}

					});

				}

				setCloneFunc(item);

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

		//***
		items.each(function(_, e) {

			var toRemove = undefined;

			if($(e).attr("id") == undefined) {
				DynamicList.objectCount++;
				$(e).attr("id", "sn-cloneableElement-" + DynamicList.objectCount);
				toRemove = $("#sn-cloneableElement-" + DynamicList.objectCount);
			} else {
				toRemove = $("#" + $(e).attr("id"));
			}

			var setRemoveFunc = function(rootEl) {

				rootEl.children(self.settings.removeButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemRemove(toRemove))
							self.doRemoveItem(toRemove);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setRemoveFunc($(el));
					}

				});

			}

			setRemoveFunc($(e));

			var setEditFunc = function(rootEl) {

				rootEl.children(self.settings.editButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemEdit(toRemove, toRemove.data("index")))
							self.doEditItem(toRemove);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setEditFunc($(el));
					}

				});

			}

			setEditFunc(toRemove);


			var setCloneFunc = function(rootEl) {

				rootEl.children(self.settings.cloneButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemClone(toRemove))
							self.doCloneItem(toRemove);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setCloneFunc($(el));
					}

				});

			}

			setCloneFunc(toRemove);

		});
		//***


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

			var setCloneFunc = function(rootEl) {

				rootEl.children(self.settings.cloneButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemClone(newItem))
							self.doCloneItem(newItem);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setCloneFunc($(el));
					}

				});

			}

			setCloneFunc(newItem);

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

	this.doCloneItem = function(item) {
		
		var self = this;

		var items = this.parent.children(this.settings.cloneableElement);
		
		if(self.template !== undefined) {
			
			var last = items.length == 0? undefined: items.last();
			var newItem = item.clone(true);
			newItem.data("sort", item.data("sort"));
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

			var setCloneFunc = function(rootEl) {

				rootEl.children(self.settings.cloneButton).each(function(index, el) {
					
					$(el).click(function() {

						if(self.settings.onItemClone(newItem))
							self.doCloneItem(newItem);
						
					})

				});

				rootEl.children().each(function(index, el) {
					
					if(!$(el).isDynamicList()) {
						setCloneFunc($(el));
					}

				});

			}

			setCloneFunc(newItem);

			newItem.data("sort", item.data("sortValue"));

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

	this.doRemoveItem = function(item, isAnimate) {
		
		if(isAnimate == undefined)
			isAnimate = true;

		var self = this;
		var items = self.parent.children(self.settings.cloneableElement);

		if(items.length > 0) {

			el = item;
			
			if(isAnimate) {
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
				
			}

			setTimeout(function() {
				item.find("*").remove();
				item.remove();
				self.settings.onItemRemoved(item);
				self.sortItems();
			}, isAnimate? 250: 0);		

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
 
			self.doRemoveItem($(this), false);
			
		});

		self.showStatus("Clearing");

	} 
	
	this.doSortItems = function() {
		this.sortItems();
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

/* _sn-3-input-mask.js */

var sn_inputmask = function() {

	var inputTipTemplate = "" +
		"<div class=\"sn-input-tip\"> Tip </div>"
	"";

	var createTip = function() {
		var tip = $($.parseHTML(inputTipTemplate));
		tip.hide();
		return tip;
	}

	var showTip = function(tip, text) {
		
		if(!tip.data("active")) {
			
			tip.data("active", true);
			tip.text(text);
			tip.fadeIn("fast");

			setTimeout(function() {
				tip.data("active", false);
				tip.fadeOut("fast");
			}, 3000);
		}

	}

	var addUnit = function(el) {
		//if(el.data("unit")) {
		//	el.val( el.val() + " " + el.data("unit") );
		//}
	}

	var removeUnit = function(el) {
		//el.val( el.val().replace(" " + el.data("unit"), "") );
	}

	return {

		doInit : function() {

			$("input[type=text]").each(function(_, e) {

				var el = $(e);
				var tip = createTip();
				el.parent().append(tip);
				el.on("change paste keyup", function() {
					var input = $(this);

					if(input.data("max-length")) {
						var reg1 = new RegExp("^.{0," + input.data("max-length") + "}$");
						var reg2 = new RegExp("^.{0," + input.data("max-length") + "}");

						if(!reg1.test(input.val())) {
							input.val( input.val().match(reg2)[0] );
							showTip(tip, input.data("max-length-tip"));
						}
					}
				});

			});

			$("input[type=email]").each(function(_, e) {

				var el = $(e);
				var tip = createTip();
				el.parent().append(tip);
				el.on("change paste keyup", function() {
					var input = $(this);

					var reg = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i

					if(!reg.test(input.val())) {
						input.addClass("sn-textfield__input-error");
						showTip(tip, input.data("type-tip"));
					} else {
						input.removeClass("sn-textfield__input-error");
					}
				});

			});

			$("input[type=integer], input[type=decimal]").each(function(_, e) {

				var regInteger1 = /^\-?(\d+)?$/
				var regInteger2 = /^\-?(\d+)?/

				var regDecimal1 = /^\-?(\d+)?\.?(\d{1,2})?$/
				var regDecimal2 = /^\-?(\d+)?\.?(\d{1,2})?/
				var regDecimal3 = /^\-?(\d+)?\.$/
				var regDecimal4 = /^\-?\.(\d{1,2})?$/

				var el = $(e);
				var tip = createTip();
				el.parent().append(tip);

				if(el.val() === "")
					if(el.attr("type") === "integer") 					
						el.val("0");
					if(el.attr("type") === "decimal") 					
						el.val("0.00");
				addUnit(el);

				el.on("change paste keyup", function() {
					var input = $(this);

					if(input.attr("type") === "integer") {
						
						if(!regInteger1.test(input.val())) {
							var match = input.val().match(regInteger2);
							match = match == null? []: match;
							input.val( match.length > 0? match[0]: "" );
						}

					} else if(input.attr("type") === "decimal") {
						if(!regDecimal1.test(input.val())) {
							var match = input.val().match(regDecimal2);
							match = match == null? []: match;
							input.val( match.length > 0? match[0]: "" );
						}

					}

					var val = parseFloat(input.val());

					if(input.data("max") !== undefined) {
						var max = parseFloat(input.data("max"));
						if(val > max) {
							input.val("" + max);
							showTip(tip, input.data("max-tip"));
						}
					}
					if(input.data("min") !== undefined) {
						var min = parseFloat(input.data("min"));						
						if(val < min) {
							input.val("" + min);
							showTip(tip, input.data("min-tip"));
						}
					}
					
				});

				el.focusin(function() {
					removeUnit($(this));
				});

				el.focusout(function() {
					var input = $(this);
					if(input.val() == "." || input.val() == "" || input.val() == "-")
						input.val("0");
					if(input.attr("type") === "integer") 					
						input.val( parseInt(input.val()) );
					if(input.attr("type") === "decimal") 					
						input.val( parseFloat(input.val()).toFixed(2) );

					addUnit(input);
				});

			});
			
		}

	};

} ();


/* _sn-4-parallax-background.js */

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
	    		$(".sn-header__fab").fadeIn();
	    	} else {
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


/* _sn-5-toast.js */

var sn_toast = function() {

	var templateRoot = "" + 
		"<div class=\"sn-toast\">" + 
		"";

	var tamplateToast = "" + 
		"<div class=\"sn-toast__message\">" + 
			"<div class=\"sn-toast__text\"></div>" + 
			"<i class=\"sn-toast__icon material-icons\">face</i>" + 
			"<div class=\"sn-toast__loading\"></div>" + 
		"</div>" + 
		"";

	var toastSelector = ".sn-toast";
	var toastTextSelector = ".sn-toast__text";

	var createToast = function(message, type, showProgress) {
		
		var toast = $($.parseHTML(tamplateToast));
		toast.find(toastTextSelector).text(message);

		var color = "";
		var colorLoading = "";
		var icon = "";

		if(type === "informacao") {
			color = "mdl-color-text--blue-600";
			colorLoading = "mdl-color--blue-300";
			icon = "info";
		} else if(type === "sucesso") {
			color = "mdl-color-text--green-600";
			colorLoading = "mdl-color--green-300";
			icon = "done";
		} else if(type === "aviso") {
			color = "mdl-color-text--orange-600";
			colorLoading = "mdl-color--orange-300";
			icon = "warning";
		} else if(type === "erro") {
			color = "mdl-color-text--red-600";
			colorLoading = "mdl-color--red-300";
			icon = "error";
		} else {
			color = "mdl-color-text--grey-600";
			colorLoading = "mdl-color--teal-300";
			icon = "clear";
		}

		toast.find("*").addClass(color);
		if (showProgress) toast.find(".sn-toast__loading").addClass(colorLoading);
		toast.find(".sn-toast__icon").text(icon);

		toast.find(".sn-toast__icon").hover(function() {
			toast.find(".sn-toast__icon").text("clear");
		});
		toast.find(".sn-toast__icon").mouseout(function() {
			toast.find(".sn-toast__icon").text(icon);
		});
		toast.find(".sn-toast__icon").click(function() {
			removeToast(toast);
		});

		return toast;

	}

	var showToast = function(toast, delay, postDelay) {
		var height = toast.height();
		toast.height("0");
		toast.css("margin-top", "0");
		toast.css("margin-bottom", "0");
		toast.css("opacity", "0");

		var anim = new Animation(toast).doSequentially(
			new Animation().doAnimate(
				{"height": "0px", specialEasing: {height: "linear"}},
				{duration: delay, queue: false}
			), 
			new Animation().doAnimate(
				{"height": height + "px", "margin-top": "8px", "margin-bottom": "8px", opacity: 1.0, specialEasing: {height: "linear"}},
				{duration: 200, queue: false}
			)
		).doPlay();

		var anim = new Animation($(".sn-toast__loading")).doSequentially(
			new Animation().doAnimate(
				{"right": "0%", specialEasing: {height: "linear"}},
				{duration: delay + postDelay + 200}
			)
		).doPlay();

		setTimeout(function() {

			removeToast(toast);

		}, postDelay + delay + 200);

	}

	var removeToast = function(toast) {

		var anim = new Animation(toast).doSequentially(
			new Animation().doAnimate(
				{opacity: 0.0, specialEasing: {height: "linear"}},
				{duration: 300, queue: false}
			), 
			new Animation().doAnimate(
				{"height": "0px", "margin-top": "0px", "margin-bottom": "0px", specialEasing: {height: "linear"}},
				{duration: 300, queue: false}
			)
		).doPlay();

		setTimeout(function() {
			toast.remove();
		}, 700);

	}

	return {

		doInit : function() {

			var toasts = $(toastSelector);
			toasts.remove();
			
			var container = $($.parseHTML(templateRoot));
			$("body").append(container);

			var delay = 500;

			toasts.each(function() {
				var el = $(this);

				postDelay = el.data("duration") !== undefined? el.data("duration"): 5000;
				toast = createToast(el.text(), el.data("type"), el.data("showprogress"))

				container.append(toast);

				showToast(toast, delay, postDelay);
				delay += 500;

			});
			
		}, 

		doShowToast : function(setts) {

			var settings = {
				text: "", 
				type: "", 
				duration: 5000, 
				showProgress: true
			};

			for(k in setts)
				settings[k] = setts[k];

			var container = $(".sn-toast");

			var delay = 100;
			var postDelay = settings.duration;

			toast = createToast(settings.text, settings.type, settings.showProgress)

			container.append(toast);

			showToast(toast, delay, postDelay);

		}

	};

} ();

