import styled from 'styled-components';

export const CanalLinha = styled.div`
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 6px 0;
    cursor: pointer;
  
    &:hover {
        background-color: #191b1f; 
    }
`;

export const AvatarStreamer = styled.div`
    width: 35px;
    height: 35px;
    border-radius: 50%; 
  
  
    background-image: url(${props => props.image});
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
  
    flex-shrink: 0;
`;

export const CanalInfo = styled.div`
    display: flex;
    flex-direction: column;
  
  h4 {
      font-size: 14px;
      margin: 0;
      color: #fff;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
      width: 100px;
  }
  
  p {
      font-size: 12px;
      margin: 0;
      color: #a2a2a2;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
      width: 100px;
  }
`;