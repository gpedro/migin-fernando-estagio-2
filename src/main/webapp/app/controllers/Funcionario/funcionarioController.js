(function() {

	angular.module('app').controller('FuncionarioController',
			FuncionarioController);

	function FuncionarioController($scope, $routeParams) {

		// Propriedades da pagina

		$scope.Titulo = "Cadastrar ";
		$scope.Titulo2 = "Funcionario";

		$scope.IsDisabled = false;
		$scope.limparCampos = function() {
			$scope.Funcionario = {};
			$scope.Funcionario.id = 0;
			$scope.Funcionario.nome = "";
			$scope.Funcionario.cpf = "";
			$scope.Funcionario.rg = "";
			$scope.Funcionario.dataNascimento = "";
			$scope.Funcionario.sexo = "";
			$scope.Funcionario.estadoCivil = "selecione";
			$scope.Funcionario.email = "";
			$scope.Funcionario.senha = "";
			$scope.Funcionario.telefones = [];
			$scope.Funcionario.enderecos = [];
		};

		$scope.bloquearCampos = function() {
			$scope.IsDisabled = true;
		};

		$scope.configurarTela = function(modo) {
			switch (modo) {
			case "1":
				$scope.Titulo = "Cadastrar ";
				break;

			case "2":
				$scope.Titulo = "Editar ";
				break;

			case "3":
				$scope.Titulo = "Vizualizar ";
				$scope.bloquearCampos();
				break;
			}

		};

		$scope.cadastrar = function() {

			$.ajax({
				url : "ServletFuncionario",
				type : 'POST',
				dataType : 'json',
				data : JSON.stringify($scope.Funcionario),
				contentType : 'application/json',
				mimeType : 'application/json',

				success : function() {
					alert("Success: ");
				},
				error : function() {
					alert("error: ");
				}
			});

			$scope.limparCampos();
			$scope.configurarTela(1);
		}

		$scope.adicionarTelefone = function() {
			$scope.Funcionario.telefones.push(angular.copy($scope.telefone));
			$scope.telefone = {};
		};

		$scope.removerTelefone = function(telefone) {
			var telefoneRemover = $scope.Funcionario.telefones
					.indexOf(telefone);
			$scope.Funcionario.telefones.splice(telefoneRemover);
		};

		$scope.adicionarEnderecoe = function() {
			$scope.Funcionario.enderecos.push($scope.endereco);
			$scope.endereco = [];
		};

		$scope.Modo = "";

		if ($routeParams.modo !== undefined && $routeParams.modo !== null)
			$scope.Modo = $routeParams.modo; // 1 = Cadastrar, 2 = Editar e 3 = Vizualizar

		// Objeto
		$scope.limparCampos();

		if ($routeParams.id !== undefined && $routeParams.id !== null)
			$scope.Funcionario.Id = $routeParams.id;

		$scope.configurarTela($scope.Modo);
	}

})();