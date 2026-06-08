import styled from 'styled-components';

export const BannerContainer = styled.div`
  width: 100%;
  max-width: 1100px; /* Trava a largura para não estourar em telas grandes */
  height: 380px;     /* Altura perfeita e compacta igual ao print */
  margin: 0 auto 32px auto; /* Centraliza na tela e joga margem para baixo */
  display: grid;
  grid-template-columns: 1fr 300px; /* Live pega o espaço total, Chat fixo em 300px */
  gap: 16px;
`;

export const VideoSection = styled.div`
  position: relative;
  background-image: url(${props => props.image});
  background-size: cover;
  background-position: center;
  border-radius: 8px;
  overflow: hidden;
  display: flex;
  align-items: flex-end;
    
`;

export const LiveIndicator = styled.span`
  position: absolute;
  top: 12px;
  left: 12px;
  background-color: rgba(0, 0, 0, 0.6);
  padding: 4px 8px;
  border-radius: 4px;
  font-size: 12px;
  font-weight: bold;
  display: flex;
  align-items: center;
  gap: 6px;

  &::before {
    content: '';
    width: 8px;
    height: 8px;
    background-color: #53fc18; /* Bolinha verde de On-line */
    border-radius: 50%;
  }
`;

export const VideoFooter = styled.div`
    position: absolute;
    bottom: 16px; 
    left: 16px;   
    right: 16px;  

    background: rgba(0, 0, 0, 0.60);
    backdrop-filter: blur(15px);
    -webkit-backdrop-filter: blur(15px); 
    border-radius: 16px;
    border: 1px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37);
    
    padding: 10px;
`;

export const StreamerInfo = styled.div`
    display: flex;
    align-items: center;
    gap: 20px;
    height: 100px;
    padding: 10px;

  img {
    width: 44px;
    height: 44px;
    border-radius: 50%;
    border: 2px solid #00e701;
  }
`;

export const ButtonSeta = styled.button`
   
    background-color: transparent;
    border: none;

    &:hover {
    background-color: #53fc18;
`;

export const StreamerDetail = styled.div`
    display: flex;
    align-items: center;
    gap: 10px;
`;

export const StreamerDescription = styled.div`
    position: relative;
    
    h3 {
        font-size: 16px;
        font-weight: 700;
        align-items: flex-start;
    }

    h4 {
        font-size: 12px;
        width:200px;
        color: #a2a2a2;
        margin-top: 2px;
        background-color: #42474D;
        border-radius: 8px;
        padding: 3px 6px;
    }

    p {
        font-size: 12px;
        width: 100px;
    }
`;

export const StreamerTitle = styled.div`
    display: flex;
    flex-direction: row;
    column-gap: 5px;
    align-items: center;
`;

export const FooterBtn = styled.div`
    position: relative; 
    display: flex;
    flex-direction: column ;
    align-items: center;
    row-gap: 20px;
 
    .setasNavegacao {

        align-self: end;
    }
`;

export const AssistirBtn = styled.button`
    background-color: #00e701;
    color: #000;
    border: none;
    padding: 9px;
    border-radius: 6px;
    font-weight: 700;
    font-size: 14px;
    cursor: pointer;
    
    &:hover {
        background-color: #53fc18;
    }
`;

export const ChatSection = styled.div`
    background-color: #191b1f;
    border-radius: 8px;
    border: 1px solid #24272c;
    padding: 16px;
    display: flex;
    flex-direction: column;
    gap: 12px;
    overflow-y: hidden;
`;

export const ChatHeader = styled.div`
    font-size: 14px;
    font-weight: 700;
    border-bottom: 1px solid #24272c;
    padding-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;
`;

export const ChatMessage = styled.p`
    font-size: 13px;
    line-height: 1.4;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;

  strong {
    color: #53fc18; /* Cor fictícia para nicks */
    margin-right: 6px;
  }
`;