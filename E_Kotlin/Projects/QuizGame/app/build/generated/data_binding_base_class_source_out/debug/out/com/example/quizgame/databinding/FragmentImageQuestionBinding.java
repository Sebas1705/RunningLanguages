// Generated by view binder compiler. Do not edit!
package com.example.quizgame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.quizgame.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentImageQuestionBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageButton answerImageA;

  @NonNull
  public final ImageButton answerImageB;

  @NonNull
  public final ImageButton answerImageC;

  @NonNull
  public final ImageButton answerImageD;

  @NonNull
  public final TextView questionImages;

  private FragmentImageQuestionBinding(@NonNull FrameLayout rootView,
      @NonNull ImageButton answerImageA, @NonNull ImageButton answerImageB,
      @NonNull ImageButton answerImageC, @NonNull ImageButton answerImageD,
      @NonNull TextView questionImages) {
    this.rootView = rootView;
    this.answerImageA = answerImageA;
    this.answerImageB = answerImageB;
    this.answerImageC = answerImageC;
    this.answerImageD = answerImageD;
    this.questionImages = questionImages;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentImageQuestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentImageQuestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_image_question, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentImageQuestionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.answer_image_A;
      ImageButton answerImageA = ViewBindings.findChildViewById(rootView, id);
      if (answerImageA == null) {
        break missingId;
      }

      id = R.id.answer_image_B;
      ImageButton answerImageB = ViewBindings.findChildViewById(rootView, id);
      if (answerImageB == null) {
        break missingId;
      }

      id = R.id.answer_image_C;
      ImageButton answerImageC = ViewBindings.findChildViewById(rootView, id);
      if (answerImageC == null) {
        break missingId;
      }

      id = R.id.answer_image_D;
      ImageButton answerImageD = ViewBindings.findChildViewById(rootView, id);
      if (answerImageD == null) {
        break missingId;
      }

      id = R.id.question_images;
      TextView questionImages = ViewBindings.findChildViewById(rootView, id);
      if (questionImages == null) {
        break missingId;
      }

      return new FragmentImageQuestionBinding((FrameLayout) rootView, answerImageA, answerImageB,
          answerImageC, answerImageD, questionImages);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}