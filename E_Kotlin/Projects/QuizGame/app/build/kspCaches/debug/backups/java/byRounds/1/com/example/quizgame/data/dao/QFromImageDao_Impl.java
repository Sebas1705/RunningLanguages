package com.example.quizgame.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.quizgame.data.entities.QFromImageEntity;
import com.example.quizgame.data.typeconverters.AnswersConverter;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class QFromImageDao_Impl implements QFromImageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QFromImageEntity> __insertionAdapterOfQFromImageEntity;

  private final AnswersConverter __answersConverter = new AnswersConverter();

  public QFromImageDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQFromImageEntity = new EntityInsertionAdapter<QFromImageEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `qFromImage_table` (`question`,`image`,`correctAnswer`,`answers`,`type`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QFromImageEntity entity) {
        statement.bindString(1, entity.getQuestion());
        if (entity.getImage() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getImage());
        }
        statement.bindLong(3, entity.getCorrectAnswer());
        final String _tmp = __answersConverter.toStringList(entity.getAnswers());
        statement.bindString(4, _tmp);
        statement.bindString(5, entity.getType());
      }
    };
  }

  @Override
  public Object insertQFromImage(final QFromImageEntity qFromImage,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfQFromImageEntity.insert(qFromImage);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertQFromImages(final List<QFromImageEntity> qFromImage,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfQFromImageEntity.insert(qFromImage);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public List<QFromImageEntity> getAllQFromImage() {
    final String _sql = "SELECT * FROM qFromImage_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfCorrectAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "correctAnswer");
      final int _cursorIndexOfAnswers = CursorUtil.getColumnIndexOrThrow(_cursor, "answers");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<QFromImageEntity> _result = new ArrayList<QFromImageEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final QFromImageEntity _item;
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final Integer _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getInt(_cursorIndexOfImage);
        }
        final int _tmpCorrectAnswer;
        _tmpCorrectAnswer = _cursor.getInt(_cursorIndexOfCorrectAnswer);
        final List<String> _tmpAnswers;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfAnswers);
        _tmpAnswers = __answersConverter.fromStringList(_tmp);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new QFromImageEntity(_tmpQuestion,_tmpImage,_tmpCorrectAnswer,_tmpAnswers,_tmpType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<QFromImageEntity> getAllTypedQFromImage(final String type) {
    final String _sql = "SELECT * FROM qFromImage_table WHERE type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, type);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfCorrectAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "correctAnswer");
      final int _cursorIndexOfAnswers = CursorUtil.getColumnIndexOrThrow(_cursor, "answers");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<QFromImageEntity> _result = new ArrayList<QFromImageEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final QFromImageEntity _item;
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final Integer _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getInt(_cursorIndexOfImage);
        }
        final int _tmpCorrectAnswer;
        _tmpCorrectAnswer = _cursor.getInt(_cursorIndexOfCorrectAnswer);
        final List<String> _tmpAnswers;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfAnswers);
        _tmpAnswers = __answersConverter.fromStringList(_tmp);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new QFromImageEntity(_tmpQuestion,_tmpImage,_tmpCorrectAnswer,_tmpAnswers,_tmpType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
