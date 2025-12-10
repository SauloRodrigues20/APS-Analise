public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO PADRÃO SINGLETON ===\n");
        
        // Obtendo a primeira instância da sessão
        System.out.println("1. Obtendo primeira instância da sessão:");
        SessaoUsuario sessao1 = SessaoUsuario.getInstancia();
        
        // Obtendo a segunda "instância" da sessão
        System.out.println("\n2. Obtendo segunda instância da sessão:");
        SessaoUsuario sessao2 = SessaoUsuario.getInstancia();
        
        // Provando que é a mesma instância
        System.out.println("\n3. Verificando se as instâncias são iguais:");
        System.out.println("sessao1 == sessao2? " + (sessao1 == sessao2));
        System.out.println("HashCode sessao1: " + System.identityHashCode(sessao1));
        System.out.println("HashCode sessao2: " + System.identityHashCode(sessao2));
        System.out.println("COMPROVADO: Apenas UMA instância foi criada!\n");
        
        System.out.println("4. Tentando acessar painel SEM autenticação:");
        try {
            sessao1.acessarPainel();
        } catch (SecurityException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        System.out.println("\n5. Tentando obter cliente SEM autenticação:");
        try {
            Cliente cliente = sessao1.getCliente();
        } catch (SecurityException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        System.out.println("\n6. Realizando autenticação:");
        sessao1.autenticar("joao.silva@email.com", "senha123");
        
        System.out.println("\n7. Acessando painel COM autenticação:");
        sessao1.acessarPainel();
        
        System.out.println("8. Obtendo informações do cliente:");
        Cliente cliente = sessao1.getCliente();
        System.out.println("Cliente obtido: " + cliente);
        
        System.out.println("\n9. Atualizando informações do cliente:");
        sessao1.setInformacaoCliente("João Silva", "joao.silva@email.com", "(11) 98765-4321");
        
        System.out.println("\n10. Verificando informações atualizadas:");
        Cliente clienteAtualizado = sessao1.getCliente();
        System.out.println("Cliente atualizado: " + clienteAtualizado);
        
        System.out.println("\n11. Acessando através de 'sessao2' (mesma instância):");
        sessao2.acessarPainel();
        
        System.out.println("12. Cliente obtido através de sessao2:");
        Cliente clientePorSessao2 = sessao2.getCliente();
        System.out.println(clientePorSessao2);
        
        System.out.println("\n13. Realizando logout:");
        sessao1.logout();
        
        System.out.println("\n14. Tentando acessar painel APÓS logout:");
        try {
            sessao2.acessarPainel();
        } catch (SecurityException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
