import React from 'react';
import { CanalLinha, AvatarStreamer, CanalInfo } from './styles';

export default function Canal({ nome, jogo, viewers, foto }) {
    return (
        <CanalLinha>
            <AvatarStreamer image={foto} />
            <CanalInfo>
                <h4>{nome}</h4>
                <p>{jogo}</p>
            </CanalInfo>
            <span style={{ color: '#ea1f1f', fontSize: '12px', marginLeft: 'auto' }}>
                ● {viewers}
            </span>
        </CanalLinha>
    );
}