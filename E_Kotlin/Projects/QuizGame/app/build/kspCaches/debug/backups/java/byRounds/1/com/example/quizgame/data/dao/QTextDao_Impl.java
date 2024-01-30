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
import com.example.quizgame.data.entities.QTextEntity;
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
public final class QTextDao_Impl implements QTextDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QTextEntity> __insertionAdapterOfQTextEntity;

  private final AnswersConverter __answersConverter = new AnswersConverter();

  public QTextDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQTextEntity = new EntityInsertionAdapter<QTextEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `qText_table` (`question`,`correctAnswer`,`answers`,`type`,`image`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QTextEntity entity) {
        statement.bindString(1, entity.getQuestion());
        statement.bindLong(2, entity.getCorrectAnswer());
        final String _tmp = __answersConverter.toStringList(entity.getAnswers());
        statement.bindString(3, _tmp);
        statement.bindString(4, entity.getType());
        if (entity.getImage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getImage());
        }
      }
    };
  }

  @Override
  public Object insertQText(final QTextEntity qText, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfQTextEntity.insert(qText);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertQTexts(final List<QTextEntity> qText,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfQTextEntity.insert(qText);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public List<QTextEntity> getAllQText() {
    final String _sql = "SELECT * FROM qText_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfCorrectAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "correctAnswer");
      final int _cursorIndexOfAnswers = CursorUtil.getColumnIndexOrThrow(_cursor, "answers");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final List<QTextEntity> _result = new ArrayList<QTextEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final QTextEntity _item;
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final int _tmpCorrectAnswer;
        _tmpCorrectAnswer = _cursor.getInt(_cursorIndexOfCorrectAnswer);
        final List<String> _tmpAnswers;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfAnswers);
        _tmpAnswers = __answersConverter.fromStringList(_tmp);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new QTextEntity(_tmpQuestion,_tmpCorrectAnswer,_tmpAnswers,_tmpType);
        final Integer _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getInt(_cursorIndexOfImage);
        }
        _item.setImage(_tmpImage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<QTextEntity> getAllTypedQText(final String type) {
    final String _sql = "SELECT * FROM qText_table WHERE type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, type);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfCorrectAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "correctAnswer");
      final int _cursorIndexOfAnswers = CursorUtil.getColumnIndexOrThrow(_cursor, "answers");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final List<QTextEntity> _result = new ArrayList<QTextEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final QTextEntity _item;
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final int _tmpCorrectAnswer;
        _tmpCorrectAnswer = _cursor.getInt(_cursorIndexOfCorrectAnswer);
        final List<String> _tmpAnswers;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfAnswers);
        _tmpAnswers = __answersConverter.fromStringList(_tmp);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new QTextEntity(_tmpQuestion,_tmpCorrectAnswer,_tmpAnswers,_tmpType);
        final Integer _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getInt(_cursorIndexOfImage);
        }
        _item.setImage(_tmpImage);
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
