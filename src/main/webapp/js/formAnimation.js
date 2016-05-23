$this = $('.navbar-nav li #newUser');
$this.click(function(e) {
	e.preventDefault();
	$('.escondido').slideUp(400);
	if (e.isDefaultPrevented()) {
		continueClicked();
	}

	function continueClicked() {
		setTimeout(function() {
			location.href = $this.attr('href')
		}, 500);
	}
})

$nc = $('#newAcc');
$nc.click(function(e) {
	e.preventDefault();
	$('.escondido').slideUp(400);
	if (e.isDefaultPrevented()) {
		continueClicked();
	}

	function continueClicked() {
		setTimeout(function() {
			location.href = $nc.attr('href')
		}, 500);
	}
})

$uf = $('#countryForm .btnForm #countryButton');
$uf.click(function(e) {
	e.preventDefault();
	$('.escondido').slideUp(400);
	if (e.isDefaultPrevented()) {
		continueClicked();
	}

	function continueClicked() {
		setTimeout(function() {
			$('#countryForm').submit(function(event) {
				$.ajax({
					data : $(this).serialize(),
					type : $(this).attr('method'),
					url : $(this).attr('action'),
					success : function(response) {
						document.location.href = response;
					}
				});
				return false;
			});
		}, 500);
	}
})

$lg = $('.navbar-nav li #log-in');
$lg.click(function(e) {
	e.preventDefault();
	$('.escondido').slideUp(400);
	if (e.isDefaultPrevented()) {
		continueClicked();
	}

	function continueClicked() {
		setTimeout(function() {
			location.href = $lg.attr('href')
		}, 500);
	}
})

$('.escondido').slideDown(400);