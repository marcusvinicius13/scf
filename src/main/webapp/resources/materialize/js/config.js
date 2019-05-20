/**
 * Arquivo de configuração java script da tela!
 * Marcus Vinicius
 */

/*
	$(document).ready(function(){
	    $('.modal').modal(  
	    );
	});
	
	$(document).ready(function(){
		$('.modify').click(function(){
			$(this).attr('href', '#modal');
		});
	});
*/

document.addEventListener('DOMContentLoaded', function() {
				    	
	var datepicker_pt_br = {
	    today: 'Hoje',
	    clear: 'Limpar',
	    done: 'Ok',
	    nextMonth: 'Próximo mês',
	    previousMonth: 'Mês anterior',
	    weekdaysAbbrev: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
	    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
	    weekdays: ['Domingo', 'Segunda-Feira', 'Terça-Feira', 'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira', 'Sábado'],
	    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
	    months: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro']
			
	}
				
	var options = {
	    container: 'body',
	    showDaysInNextAndPreviousMonths: true,
	    i18n: datepicker_pt_br,
	    format:'dd/mm/yyyy',
	    
	   //outras configurações da data
	}
			    
    var elems = document.querySelectorAll('.datepicker'); 	 // Inicializar datas
	var instances = M.Datepicker.init(elems, options);		 // Inicializar datas

	var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, options);
    
    
    var options = {};
    
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems, options);
   
});

$(document).ready(function() {
    $('.timepicker').timepicker({
        i18n: {
            cancel: 'Cancelar',
            clear: 'Limpar',
            done: 'Ok'
        },
        twelveHour : false, // 12 horas, usa AM/PM
        autoclose: false  //Fecha o timepicker automaticamente apos selecionar a hora
    });
});



