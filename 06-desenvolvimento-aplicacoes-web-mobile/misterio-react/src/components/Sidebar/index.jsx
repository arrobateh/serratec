import { SidebarContainer, NavLink, TitleSection, CanalLinha, Avatar, InfoCanal, ViewersBadge } from './styles';

export default function Sidebar() {
    const recomendados = [
        { id: 1, nome: "Alanzoka", jogo: "Kingdom Comes Deliverance 2", viewers: "3.5K", foto: "./avatarAlanzoka.jpg" },
        { id: 2, nome: "BrksEdu", jogo: "Resident Evil Requien", viewers: "1.2K", foto: "./avatarBrksEdu.jpg" },
        { id: 3, nome: "Mr Bruno", jogo: "Euro Truck Simulator 2", viewers: "950", foto: "./avatarMrBruno.jpg" }
    ];

    return (
        <SidebarContainer>
            <NavLink active>Início</NavLink>
            <NavLink>Procurar</NavLink>
            <NavLink>Seguindo</NavLink>

            <TitleSection>Canais Recomendados</TitleSection>

            {recomendados.map(canal => (
                <CanalLinha key={canal.id}>
                    <Avatar image={canal.foto} />
                    <InfoCanal>
                        <h4>{canal.nome}</h4>
                        <p>{canal.jogo}</p>
                    </InfoCanal>
                    <ViewersBadge>● {canal.viewers}</ViewersBadge>
                </CanalLinha>
            ))}
        </SidebarContainer>
    );
}