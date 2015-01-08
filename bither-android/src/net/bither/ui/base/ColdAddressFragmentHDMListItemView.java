/*
 *
 *  * Copyright 2014 http://Bither.net
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package net.bither.ui.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import net.bither.R;
import net.bither.bitherj.core.HDMKeychain;
import net.bither.ui.base.dialog.DialogXRandomInfo;

/**
 * Created by songchenwen on 15/1/7.
 */
public class ColdAddressFragmentHDMListItemView extends FrameLayout {
    private Activity activity;
    private HDMKeychain keychain;
    private ImageView ivType;
    private ImageButton ibtnXRandomLabel;

    public ColdAddressFragmentHDMListItemView(Activity context) {
        super(context);
        activity = context;
        View v = LayoutInflater.from(activity).inflate(R.layout
                .list_item_address_fragment_cold_hdm, null);
        addView(v, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {
        ivType = (ImageView) findViewById(R.id.iv_type);
        ibtnXRandomLabel = (ImageButton) findViewById(R.id.ibtn_xrandom_label);
        ibtnXRandomLabel.setOnLongClickListener(DialogXRandomInfo.InfoLongClick);
        ivType.setOnLongClickListener(typeClick);
        findViewById(R.id.ibtn_seed_option).setOnClickListener(seedOptionClick);
        findViewById(R.id.ibtn_qr_code_option).setOnClickListener(qrCodeOptionClick);
    }

    private OnLongClickListener typeClick = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            seedOptionClick.onClick(v);
            return true;
        }
    };

    private OnClickListener seedOptionClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO seed option hdm cold
        }
    };

    private OnClickListener qrCodeOptionClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO qr code option hdm cold
        }
    };

    public void setKeychain(HDMKeychain chain) {
        this.keychain = chain;
        if (keychain.isFromXRandom()) {
            ibtnXRandomLabel.setVisibility(View.VISIBLE);
        } else {
            ibtnXRandomLabel.setVisibility(View.INVISIBLE);
        }
    }
}
