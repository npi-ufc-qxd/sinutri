$(document).ready(function() {

	componentHandler.registerUpgradedCallback("MaterialLayout", function(elem) {
		
		var dialog = null;

		var dynamicList = $(".sn-list-exames").dynamicList({
			cloneableElement: ".sn-cloneable", 
			removeButton: ".sn-exame-remove", 
			editButton: ".sn-exame-edit", 
			onItemEdit: function(el, index) {

				if(dialog != null) {
					var type = el.find(".sn-exame-type").text();
					var val = el.find(".sn-exame-value").text();

					$(dialog).find("#sn-exame-type").val(type);
					$(dialog).find("#sn-exame-value").val(val);
					$(dialog).find("#sn-exame-item-index").val(index);

					dialog.showModal();
				}
				
			}
		});

		dialog = sn_base.doRegistryDialog({
			title: "Adicionar Exame", 
			dialog: "#sn-add-exame-modal", 
			showButton: "#sn-add-exame-button", 
			buttons: [
				{
					label: "OK",
					attrs: {id: "btn-ok", type: "submit"}, 
					action: function() {
						dialog.close();

						var index = $(dialog).find("#sn-exame-item-index").val();
						var type = $(dialog).find("#sn-exame-type").val();
						var val = $(dialog).find("#sn-exame-value").val();
						var data = {
							".sn-exame-type": {text: type},
							".sn-exame-value": {text: val} 
						};
						
						var el;

						if(index != "")
							el = dynamicList.doEditItem(index, data);
						else 
							el = dynamicList.doAddItem(data);

						componentHandler.upgradeElement(el[0]);
						el.find("*").each(function(index, el) { componentHandler.upgradeElement(el); });
						$(dialog).find("#sn-exame-item-index").val("");

					}
				}
			]
		});
			
	});

});