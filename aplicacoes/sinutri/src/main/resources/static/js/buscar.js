$(document).ready(function() {
    //colocar focus no campo após o texto 
    $.fn.setCursorPosition = function (pos) {
        this.each(function (index, elem) {
            if (elem.setSelectionRange) {
                elem.setSelectionRange(pos, pos);
            } else if (elem.createTextRange) {
                var range = elem.createTextRange();
                range.collapse(true);
                range.moveEnd("character", pos);
                range.moveStart("character", pos);
                range.select();
            }
        });
        return this;
    };  

    $("#sn-search__input").focus().setCursorPosition($("#sn-search__input").val().length);

    $("#botaoPesquisar").on("click", function(){
        $("#formBuscar").submit();
    });
    
    
    
    var dataTable = $("#sn-search-result-table").DataTable({
        columnDefs: [
            {
                targets: [ 0, 1, 2 ],
                className: "mdl-data-table__cell--non-numeric"
            }
        ]
    });

    var changeInterval = function(n) {

        $("#sn-search-result-table_length select").val(n);
        $("#sn-search-result-table_length select").trigger("change");
        $(".sn-search-actions__entries-value").text(n)

    }
    $(".sn-show-entries__list li").click(function() {
        changeInterval($(this).text());
    });
    changeInterval(10);

    $("#sn-search-result-table_length").css("display", "none");

    $("#sn-search-result-table_wrapper").addClass("sn-search-table-wrapper");
    $("#sn-search-result-table_wrapper .paginate_button").addClass("");

    $("#sn-search-result-table_filter").css("display", "none");

    
    $(".sn-search__input").on( "keyup click", function () {
        
        $("#sn-search-result-table").DataTable().search(
            $(".sn-search__input").val()
        ).draw();

    });

    $("#sn-search-result-table_info").css("display", "none");
    $("#sn-search-result-table_paginate").addClass("mdl-color--white");
    $("#sn-search-result-table_paginate").css("padding", "24px");
    $("#sn-search-result-table_paginate .paginate_button").addClass("mdl-button mdl-js-button mdl-js-ripple-effect");

    $("#sn-search-result-table_paginate").bind("DOMNodeInserted DOMNodeRemoved", function(event) {
        $("#sn-search-result-table_paginate .paginate_button").addClass("mdl-button mdl-js-button mdl-js-ripple-effect");
    });

    $(".mdl-layout__content").scroll(function(event) {
        var scroll = $(this).scrollTop();
        if(scroll > 42 + 12) {
            $(".sn-search").addClass("sn-search-fixed");
            $(".sn-main-page").css("padding-top", "84px");
        } else {
            $(".sn-search").removeClass("sn-search-fixed");
            $(".sn-main-page").css("padding-top", "42px");
        }
    });

    componentHandler.upgradeDom();
    componentHandler.upgradeElement(document.getElementById("sn-search-result-table"));
    $("#sn-search-result-table").find("*").each(function() {
        componentHandler.upgradeElement(this);
        console.log("upgradeElement");
    });
    
    
    

});