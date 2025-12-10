public class SessaoUsuario {
    private static SessaoUsuario instanciaUnica;
    
    private Cliente clienteAutenticado;
    private boolean autenticado;
    private String tokenSessao;
    
    private SessaoUsuario() {
        this.autenticado = false;
        this.clienteAutenticado = null;
        this.tokenSessao = null;
        System.out.println("[SINGLETON] Nova instância de SessaoUsuario criada.");
    }
    
    public static SessaoUsuario getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new SessaoUsuario();
        }
        return instanciaUnica;
    }
    
    public void autenticar(String email, String senha) {
        if (email != null && senha != null && !email.isEmpty() && !senha.isEmpty()) {
            this.autenticado = true;
            this.clienteAutenticado = new Cliente("Cliente Exemplo", email);
            this.tokenSessao = "TOKEN_" + System.currentTimeMillis();
            System.out.println(" Usuário autenticado com sucesso!");
            System.out.println("Token da sessão: " + tokenSessao);
        } else {
            throw new IllegalArgumentException("Credenciais inválidas!");
        }
    }
    
    public void logout() {
        this.autenticado = false;
        this.clienteAutenticado = null;
        this.tokenSessao = null;
        System.out.println(" Logout realizado com sucesso!");
    }
    
    private void verificarAutenticacao() {
        if (!autenticado) {
            throw new SecurityException("ACESSO NEGADO: Usuário não autenticado!");
        }
    }
    
    public void acessarPainel() {
        verificarAutenticacao();
        System.out.println("\n=== PAINEL DO CLIENTE ===");
        System.out.println("Bem-vindo ao painel, " + clienteAutenticado.getNome() + "!");
        System.out.println("Email: " + clienteAutenticado.getEmail());
        System.out.println("=========================\n");
    }
    
    public Cliente getCliente() {
        verificarAutenticacao();
        return clienteAutenticado;
    }
    
    public void setInformacaoCliente(String nome, String email, String telefone) {
        verificarAutenticacao();
        
        if (nome != null && !nome.isEmpty()) {
            clienteAutenticado.setNome(nome);
        }
        if (email != null && !email.isEmpty()) {
            clienteAutenticado.setEmail(email);
        }
        if (telefone != null) {
            clienteAutenticado.setTelefone(telefone);
        }
        
        System.out.println(" Informações do cliente atualizadas com sucesso!");
    }
    
    public boolean isAutenticado() {
        return autenticado;
    }
    
    public String getTokenSessao() {
        verificarAutenticacao();
        return tokenSessao;
    }
}
