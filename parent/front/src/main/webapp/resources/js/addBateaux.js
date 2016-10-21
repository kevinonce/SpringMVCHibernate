	  $(document).ready(function() {
	
		$('#bpExploitant').autocomplete({
		    source : function(requete, reponse){ 
			$.ajax({
		            url : urlSearch, 
		            dataType : 'json', 
		            data: 'query='+$('#bpExploitant').val(),
		            success : function(donnee){
		                reponse($.map(donnee, function(objet){
		                    return objet.peIcd + ' - ' + objet.peName;
		                }));
		            }
		        });
		    },
		    minLength : 3,
	        select: function( event , ui ) {
	        	event.preventDefault();
	        	$('#bpExploitant').val(ui.item.value.substring(0,ui.item.value.indexOf('-')-1));
	        }
		});
	  });