// Generated by view binder compiler. Do not edit!
package com.aelsayed.wunder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.aelsayed.wunder.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCarDetailsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView ivCarImage;

  @NonNull
  public final ProgressBar loading;

  @NonNull
  public final TextView tvAddress;

  @NonNull
  public final TextView tvAddressBase;

  @NonNull
  public final TextView tvCity;

  @NonNull
  public final TextView tvCityBase;

  @NonNull
  public final TextView tvDamageDescription;

  @NonNull
  public final TextView tvDamageDescriptionBase;

  @NonNull
  public final TextView tvFuelLevel;

  @NonNull
  public final TextView tvFuelLevelBase;

  @NonNull
  public final TextView tvIsClean;

  @NonNull
  public final TextView tvIsCleanBase;

  @NonNull
  public final TextView tvIsDamaged;

  @NonNull
  public final TextView tvIsDamagedBase;

  @NonNull
  public final TextView tvLat;

  @NonNull
  public final TextView tvLatBase;

  @NonNull
  public final TextView tvLicencePlate;

  @NonNull
  public final TextView tvLicencePlateBase;

  @NonNull
  public final TextView tvLon;

  @NonNull
  public final TextView tvLonBase;

  @NonNull
  public final TextView tvPricingParking;

  @NonNull
  public final TextView tvPricingParkingBase;

  @NonNull
  public final TextView tvPricingTime;

  @NonNull
  public final TextView tvPricingTimeBase;

  @NonNull
  public final Button tvRent;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvTitleBase;

  @NonNull
  public final TextView tvZipCode;

  @NonNull
  public final TextView tvZipCodeBase;

  private ActivityCarDetailsBinding(@NonNull RelativeLayout rootView, @NonNull ImageView ivCarImage,
      @NonNull ProgressBar loading, @NonNull TextView tvAddress, @NonNull TextView tvAddressBase,
      @NonNull TextView tvCity, @NonNull TextView tvCityBase, @NonNull TextView tvDamageDescription,
      @NonNull TextView tvDamageDescriptionBase, @NonNull TextView tvFuelLevel,
      @NonNull TextView tvFuelLevelBase, @NonNull TextView tvIsClean,
      @NonNull TextView tvIsCleanBase, @NonNull TextView tvIsDamaged,
      @NonNull TextView tvIsDamagedBase, @NonNull TextView tvLat, @NonNull TextView tvLatBase,
      @NonNull TextView tvLicencePlate, @NonNull TextView tvLicencePlateBase,
      @NonNull TextView tvLon, @NonNull TextView tvLonBase, @NonNull TextView tvPricingParking,
      @NonNull TextView tvPricingParkingBase, @NonNull TextView tvPricingTime,
      @NonNull TextView tvPricingTimeBase, @NonNull Button tvRent, @NonNull TextView tvTitle,
      @NonNull TextView tvTitleBase, @NonNull TextView tvZipCode, @NonNull TextView tvZipCodeBase) {
    this.rootView = rootView;
    this.ivCarImage = ivCarImage;
    this.loading = loading;
    this.tvAddress = tvAddress;
    this.tvAddressBase = tvAddressBase;
    this.tvCity = tvCity;
    this.tvCityBase = tvCityBase;
    this.tvDamageDescription = tvDamageDescription;
    this.tvDamageDescriptionBase = tvDamageDescriptionBase;
    this.tvFuelLevel = tvFuelLevel;
    this.tvFuelLevelBase = tvFuelLevelBase;
    this.tvIsClean = tvIsClean;
    this.tvIsCleanBase = tvIsCleanBase;
    this.tvIsDamaged = tvIsDamaged;
    this.tvIsDamagedBase = tvIsDamagedBase;
    this.tvLat = tvLat;
    this.tvLatBase = tvLatBase;
    this.tvLicencePlate = tvLicencePlate;
    this.tvLicencePlateBase = tvLicencePlateBase;
    this.tvLon = tvLon;
    this.tvLonBase = tvLonBase;
    this.tvPricingParking = tvPricingParking;
    this.tvPricingParkingBase = tvPricingParkingBase;
    this.tvPricingTime = tvPricingTime;
    this.tvPricingTimeBase = tvPricingTimeBase;
    this.tvRent = tvRent;
    this.tvTitle = tvTitle;
    this.tvTitleBase = tvTitleBase;
    this.tvZipCode = tvZipCode;
    this.tvZipCodeBase = tvZipCodeBase;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCarDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCarDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_car_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCarDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivCarImage;
      ImageView ivCarImage = ViewBindings.findChildViewById(rootView, id);
      if (ivCarImage == null) {
        break missingId;
      }

      id = R.id.loading;
      ProgressBar loading = ViewBindings.findChildViewById(rootView, id);
      if (loading == null) {
        break missingId;
      }

      id = R.id.tvAddress;
      TextView tvAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress == null) {
        break missingId;
      }

      id = R.id.tvAddressBase;
      TextView tvAddressBase = ViewBindings.findChildViewById(rootView, id);
      if (tvAddressBase == null) {
        break missingId;
      }

      id = R.id.tvCity;
      TextView tvCity = ViewBindings.findChildViewById(rootView, id);
      if (tvCity == null) {
        break missingId;
      }

      id = R.id.tvCityBase;
      TextView tvCityBase = ViewBindings.findChildViewById(rootView, id);
      if (tvCityBase == null) {
        break missingId;
      }

      id = R.id.tvDamageDescription;
      TextView tvDamageDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDamageDescription == null) {
        break missingId;
      }

      id = R.id.tvDamageDescriptionBase;
      TextView tvDamageDescriptionBase = ViewBindings.findChildViewById(rootView, id);
      if (tvDamageDescriptionBase == null) {
        break missingId;
      }

      id = R.id.tvFuelLevel;
      TextView tvFuelLevel = ViewBindings.findChildViewById(rootView, id);
      if (tvFuelLevel == null) {
        break missingId;
      }

      id = R.id.tvFuelLevelBase;
      TextView tvFuelLevelBase = ViewBindings.findChildViewById(rootView, id);
      if (tvFuelLevelBase == null) {
        break missingId;
      }

      id = R.id.tvIsClean;
      TextView tvIsClean = ViewBindings.findChildViewById(rootView, id);
      if (tvIsClean == null) {
        break missingId;
      }

      id = R.id.tvIsCleanBase;
      TextView tvIsCleanBase = ViewBindings.findChildViewById(rootView, id);
      if (tvIsCleanBase == null) {
        break missingId;
      }

      id = R.id.tvIsDamaged;
      TextView tvIsDamaged = ViewBindings.findChildViewById(rootView, id);
      if (tvIsDamaged == null) {
        break missingId;
      }

      id = R.id.tvIsDamagedBase;
      TextView tvIsDamagedBase = ViewBindings.findChildViewById(rootView, id);
      if (tvIsDamagedBase == null) {
        break missingId;
      }

      id = R.id.tvLat;
      TextView tvLat = ViewBindings.findChildViewById(rootView, id);
      if (tvLat == null) {
        break missingId;
      }

      id = R.id.tvLatBase;
      TextView tvLatBase = ViewBindings.findChildViewById(rootView, id);
      if (tvLatBase == null) {
        break missingId;
      }

      id = R.id.tvLicencePlate;
      TextView tvLicencePlate = ViewBindings.findChildViewById(rootView, id);
      if (tvLicencePlate == null) {
        break missingId;
      }

      id = R.id.tvLicencePlateBase;
      TextView tvLicencePlateBase = ViewBindings.findChildViewById(rootView, id);
      if (tvLicencePlateBase == null) {
        break missingId;
      }

      id = R.id.tvLon;
      TextView tvLon = ViewBindings.findChildViewById(rootView, id);
      if (tvLon == null) {
        break missingId;
      }

      id = R.id.tvLonBase;
      TextView tvLonBase = ViewBindings.findChildViewById(rootView, id);
      if (tvLonBase == null) {
        break missingId;
      }

      id = R.id.tvPricingParking;
      TextView tvPricingParking = ViewBindings.findChildViewById(rootView, id);
      if (tvPricingParking == null) {
        break missingId;
      }

      id = R.id.tvPricingParkingBase;
      TextView tvPricingParkingBase = ViewBindings.findChildViewById(rootView, id);
      if (tvPricingParkingBase == null) {
        break missingId;
      }

      id = R.id.tvPricingTime;
      TextView tvPricingTime = ViewBindings.findChildViewById(rootView, id);
      if (tvPricingTime == null) {
        break missingId;
      }

      id = R.id.tvPricingTimeBase;
      TextView tvPricingTimeBase = ViewBindings.findChildViewById(rootView, id);
      if (tvPricingTimeBase == null) {
        break missingId;
      }

      id = R.id.tvRent;
      Button tvRent = ViewBindings.findChildViewById(rootView, id);
      if (tvRent == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      id = R.id.tvTitleBase;
      TextView tvTitleBase = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleBase == null) {
        break missingId;
      }

      id = R.id.tvZipCode;
      TextView tvZipCode = ViewBindings.findChildViewById(rootView, id);
      if (tvZipCode == null) {
        break missingId;
      }

      id = R.id.tvZipCodeBase;
      TextView tvZipCodeBase = ViewBindings.findChildViewById(rootView, id);
      if (tvZipCodeBase == null) {
        break missingId;
      }

      return new ActivityCarDetailsBinding((RelativeLayout) rootView, ivCarImage, loading,
          tvAddress, tvAddressBase, tvCity, tvCityBase, tvDamageDescription,
          tvDamageDescriptionBase, tvFuelLevel, tvFuelLevelBase, tvIsClean, tvIsCleanBase,
          tvIsDamaged, tvIsDamagedBase, tvLat, tvLatBase, tvLicencePlate, tvLicencePlateBase, tvLon,
          tvLonBase, tvPricingParking, tvPricingParkingBase, tvPricingTime, tvPricingTimeBase,
          tvRent, tvTitle, tvTitleBase, tvZipCode, tvZipCodeBase);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
