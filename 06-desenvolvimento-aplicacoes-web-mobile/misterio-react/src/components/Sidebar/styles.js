import styled from 'styled-components';

export const SidebarContainer = styled.aside`
    grid-area: sidebar;
    background-color: #191b1f;
    border-right: 1px solid #24272c;
    padding: 20px 12px;
    display: flex;
    flex-direction: column;
    gap: 8px;
`;

export const NavLink = styled.div`
    display: flex;
    align-items: center;
    padding: 10px 12px;
    border-radius: 6px;
    font-weight: 600;
    font-size: 14px;
    cursor: pointer;
    color: ${props => props.active ? '#00e701' : '#fff'};
    background-color: ${props => props.active ? '#24272c' : 'transparent'};

  &:hover {
    background-color: #24272c;
  }
`;

export const TitleSection = styled.p`
    font-size: 11px;
    font-weight: 700;
    color: #a2a2a2;
    text-transform: uppercase;
    margin: 16px 0 8px 12px;
    letter-spacing: 0.5px;
`;

export const CanalLinha = styled.div`
    display: flex;
    align-items: center;
    padding: 6px 12px;
    border-radius: 6px;
    cursor: pointer;
    gap: 12px;

  &:hover {
    background-color: #24272c;
  }
`;

export const Avatar = styled.div`
    width: 32px;
    height: 32px;
    border-radius: 50%;
    background-image: url(${props => props.image});
    background-size: cover;
    background-position: center;
    flex-shrink: 0;
`;

export const InfoCanal = styled.div`
    display: flex;
    flex-direction: column;
    overflow: hidden;
  
  h4 {
    font-size: 13px;
    font-weight: 600;
    color: #fff;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  p {
    font-size: 11px;
    color: #a2a2a2;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
`;

export const ViewersBadge = styled.span`
    color: green;
    font-size: 11px;
    font-weight: 600;
    margin-left: auto;
`;